package com.andrea_murillo.involucrate.ui.usuario

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentNuestraInformacionBinding
import com.andrea_murillo.involucrate.model.AuthRequest
import com.andrea_murillo.involucrate.model.Ong
import com.andrea_murillo.involucrate.model.UploadResponse
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.AuthApi
import com.andrea_murillo.involucrate.network.OngApi
import com.andrea_murillo.involucrate.network.UploadApi
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class NuestraInformacionFragment : Fragment() {
    private var _binding: FragmentNuestraInformacionBinding? = null
    private val binding get() = _binding!!

    private val ongApi by lazy { ApiService.retrofit.create(OngApi::class.java) }
    private val authApi by lazy { ApiService.retrofit.create(AuthApi::class.java) }
    private val uploadApi by lazy { ApiService.retrofit.create(UploadApi::class.java) }

    private var currentOng: Ong? = null
    private var uriImagen: Uri? = null

    private val seleccionarImagen = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uriImagen = uri
        binding.imgOngLogo.setImageURI(uri)
    }

    private var usuarioId: Long = -1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuarioId = requireContext().getSharedPreferences("app_prefs", 0)
            .getLong("usuario_id", -1L)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNuestraInformacionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgOngLogo.setOnClickListener { seleccionarImagen.launch("image/*") }
        binding.btnCancelar.setOnClickListener { findNavController().popBackStack() }
        binding.btnActualizar.setOnClickListener { actualizarOng() }

        cargarDatosOng()
    }

    private fun cargarDatosOng() {
        lifecycleScope.launch {
            val resp = withContext(Dispatchers.IO) { ongApi.obtenerOngs() }
            if (resp.isSuccessful) {
                currentOng = resp.body()?.find { it.usuario.id == usuarioId }
                currentOng?.let { ong ->
                    binding.editNombreOng.setText(ong.nombreOng)
                    binding.editDescripcionOng.setText(ong.descripcion)
                    binding.editDireccionOng.setText(ong.direccion)
                    binding.editTelefonoOng.setText(ong.telefono)
                    binding.editUrlOng.setText(ong.url)
                    Glide.with(requireContext())
                        .load("http://192.168.1.160:8080/api/uploads/files/${ong.imagen}")
                        .placeholder(R.drawable.ic_placeholder_pink)
                        .into(binding.imgOngLogo)
                }
            } else {
                Toast.makeText(requireContext(), "Error cargando ONG", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun actualizarOng() {
        val nombre = binding.editNombreOng.text.toString().trim()
        val descripcion = binding.editDescripcionOng.text.toString().trim()
        val direccion = binding.editDireccionOng.text.toString().trim()
        val telefono = binding.editTelefonoOng.text.toString().trim()
        val url = binding.editUrlOng.text.toString().trim()
        val pwdActual = binding.editContrasenaActual.text.toString().trim()

        if (nombre.isEmpty() || descripcion.isEmpty() || direccion.isEmpty()
            || telefono.isEmpty() || pwdActual.isEmpty() ) {
            Toast.makeText(requireContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            // verificar contraseña actual del usuario
            val authResp = withContext(Dispatchers.IO) {
                authApi.login(AuthRequest(
                    correoElectronico = currentOng?.correoElectronico ?: "",
                    contrasena = pwdActual
                ))
            }
            if (!authResp.isSuccessful) {
                Toast.makeText(requireContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                return@launch
            }

            // subir nueva imagen si hay
            var imagenNombre = currentOng?.imagen
            uriImagen?.let { uri ->
                val stream = requireContext().contentResolver.openInputStream(uri) ?: return@let
                val file = File.createTempFile("temp_", ".jpg", requireContext().cacheDir)
                file.outputStream().use { output -> stream.copyTo(output) }
                val body = MultipartBody.Part.createFormData(
                    "file", file.name,
                    file.asRequestBody("image/*".toMediaTypeOrNull())
                )
                val upResp = withContext(Dispatchers.IO) { uploadApi.subirImagen(body) }
                if (upResp.isSuccessful) imagenNombre = upResp.body()?.nombre
            }

            // construir objeto ONG actualizado
            val orig = currentOng ?: return@launch
            val ongUpdate = Ong(
                id = orig.id,
                usuario = orig.usuario,
                nombreOng = nombre,
                descripcion = descripcion,
                direccion = direccion,
                telefono = telefono,
                imagen = imagenNombre,
                correoElectronico = orig.correoElectronico,
                url = url,
                verificada = orig.verificada
            )

            val updateResp = withContext(Dispatchers.IO) {
                ongApi.actualizarOng(orig.id ?: -1L, ongUpdate)
            }
            if (updateResp.isSuccessful) {
                Toast.makeText(requireContext(), "Datos actualizados", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            } else {
                Toast.makeText(requireContext(), "Error al actualizar ONG", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
