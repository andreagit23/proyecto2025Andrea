package com.andrea_murillo.involucrate.ui.ventas

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentDetalleProductoVentaBinding
import com.andrea_murillo.involucrate.model.Categoria
import com.andrea_murillo.involucrate.model.EstadoProducto
import com.andrea_murillo.involucrate.model.Producto
import com.andrea_murillo.involucrate.model.ProductoRequest
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.CategoriaApi
import com.andrea_murillo.involucrate.network.ProductoApi
import com.andrea_murillo.involucrate.network.UploadApi
import com.andrea_murillo.involucrate.model.UploadResponse
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.math.BigDecimal

class DetalleProductoVentaFragment : Fragment() {

    private var _binding: FragmentDetalleProductoVentaBinding? = null
    private val binding get() = _binding!!

    private val productoApi by lazy { ApiService.retrofit.create(ProductoApi::class.java) }
    private val categoriaApi by lazy { ApiService.retrofit.create(CategoriaApi::class.java) }
    private val uploadApi by lazy { ApiService.retrofit.create(UploadApi::class.java) }

    private var categorias: List<Categoria> = emptyList()
    private var productoExistente: Producto? = null
    private var uriImagen: Uri? = null
    private var productoId: Long = -1L

    private val seleccionarImagen = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            uriImagen = result.data?.data
            binding.imgSeleccionada.setImageURI(uriImagen)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productoId = arguments?.getLong("productoId") ?: -1L
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalleProductoVentaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cargarCategorias()
        setupListeners()

        if (productoId != -1L) cargarProducto(productoId)
        else binding.textEstado.text = EstadoProducto.DISPONIBLE.name
    }

    private fun setupListeners() {
        binding.imgSeleccionada.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            seleccionarImagen.launch(intent)
        }

        binding.seekPorcentajeDonacion.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar, progress: Int, fromUser: Boolean
                ) {
                    binding.textPorcentajeValor.text = "$progress%"
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            }
        )

        binding.btnGuardarProducto.setOnClickListener { guardarProducto() }
    }

    private fun cargarCategorias() {
        lifecycleScope.launch {
            val response = withContext(Dispatchers.IO) { categoriaApi.obtenerCategorias() }
            if (response.isSuccessful) {
                categorias = response.body() ?: emptyList()
                val adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_spinner_item,
                    categorias.map { it.nombre }
                )
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinnerCategoria.adapter = adapter
            }
        }
    }

    private fun cargarProducto(id: Long) {
        lifecycleScope.launch {
            val response = withContext(Dispatchers.IO) {
                productoApi.obtenerProductoPorId(id)
            }
            if (response.isSuccessful) {
                productoExistente = response.body()
                productoExistente?.let { p ->
                    if (!p.imagen.isNullOrBlank()) {
                        Glide.with(requireContext())
                            .load("http://192.168.1.160:8080/api/uploads/files/${p.imagen}")
                            .placeholder(R.drawable.ic_placeholder_pink)
                            .into(binding.imgSeleccionada)
                    }
                    binding.editNombreProducto.setText(p.nombre)
                    binding.editDescripcion.setText(p.descripcion)
                    binding.editPrecio.setText(p.precio.toString())
                    binding.textEstado.text = p.estado
                    binding.seekPorcentajeDonacion.progress = p.porcentajeDonacion
                    binding.textPorcentajeValor.text = "${p.porcentajeDonacion}%"
                    categorias.indexOfFirst { it.id == p.categoria.id }
                        .takeIf { it >= 0 }?.let {
                            binding.spinnerCategoria.setSelection(it)
                        }
                }
            }
        }
    }

    private fun subirImagen(callback: (String?) -> Unit) {
        val uri = uriImagen
        if (uri == null) {
            callback(productoExistente?.imagen)
            return
        }

        val inputStream = requireContext().contentResolver.openInputStream(uri)
        if (inputStream == null) {
            callback(null)
            return
        }

        val file = File.createTempFile("temp_", ".jpg", requireContext().cacheDir)
        file.outputStream().use { output -> inputStream.copyTo(output) }

        val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
        val body = MultipartBody.Part.createFormData("file", file.name, requestFile)

        lifecycleScope.launch {
            val response = withContext(Dispatchers.IO) {
                uploadApi.subirImagen(body)
            }
            if (response.isSuccessful) {
                val nombreSubido = response.body()?.nombre
                Log.d("UploadDebug", "Imagen subida correctamente: $nombreSubido")
                callback(nombreSubido)
            } else {
                val errorBody = response.errorBody()?.string()
                Log.e(
                    "UploadDebug",
                    "Error al subir imagen: ${response.code()} - $errorBody"
                )
                callback(null)
            }
        }
    }

    private fun guardarProducto() {
        val nombre = binding.editNombreProducto.text.toString()
        val descripcion = binding.editDescripcion.text.toString()
        val precio = binding.editPrecio.text.toString().toBigDecimalOrNull() ?: BigDecimal.ZERO
        val porcentaje = binding.seekPorcentajeDonacion.progress
        val estado = binding.textEstado.text.toString()
        val categoria = categorias.getOrNull(
            binding.spinnerCategoria.selectedItemPosition
        ) ?: return

        val userId = requireContext().getSharedPreferences(
            "app_prefs",
            Context.MODE_PRIVATE
        ).getLong("usuario_id", -1L)
        if (userId == -1L) return

        subirImagen { urlImagen ->
            if (urlImagen == null) {
                Toast.makeText(
                    requireContext(),
                    "Error al subir imagen",
                    Toast.LENGTH_SHORT
                ).show()
                return@subirImagen
            }

            val request = ProductoRequest(
                nombre             = nombre,
                descripcion        = descripcion,
                precio             = precio,
                porcentajeDonacion = porcentaje,
                imagen             = urlImagen,
                estado             = estado,
                vendedorId         = userId,
                categoriaId        = categoria.id
            )

            lifecycleScope.launch {
                val response = withContext(Dispatchers.IO) {
                    val existingId = productoExistente?.id
                    if (existingId != null) {
                        productoApi.actualizarProducto(existingId, request)
                    } else {
                        productoApi.crearProducto(request)
                    }
                }

                if (response.isSuccessful) {
                    findNavController().navigate(
                        R.id.action_editarProducto_to_ventas
                    )
                } else {
                    val err = response.errorBody()?.string()
                    Log.e(
                        "ProductoDebug",
                        "Error al guardar producto: ${response.code()} - $err"
                    )
                    Toast.makeText(
                        requireContext(),
                        "Error guardando el producto",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
