package com.andrea_murillo.involucrate.ui.compras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentDetalleProductoCompraBinding
import com.andrea_murillo.involucrate.model.Ong
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.OngApi
import com.andrea_murillo.involucrate.network.ProductoApi
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetalleProductoCompraFragment : Fragment() {

    private var _binding: FragmentDetalleProductoCompraBinding? = null
    private val binding get() = _binding!!

    // Recuperamos el productoId directamente de los argumentos
    private val productoId: Long by lazy {
        arguments?.getLong("productoId", -1L) ?: -1L
    }

    private val productoApi by lazy { ApiService.retrofit.create(ProductoApi::class.java) }
    private val ongApi by lazy { ApiService.retrofit.create(OngApi::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalleProductoCompraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cargarProducto()
        cargarOngs()
        binding.btnComprar.setOnClickListener {
            Toast.makeText(requireContext(), "Comprar aún no implementado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cargarProducto() {
        lifecycleScope.launch {
            val resp = withContext(Dispatchers.IO) {
                productoApi.obtenerProductoPorId(productoId)
            }
            if (resp.isSuccessful) {
                resp.body()?.let { p ->
                    binding.txtNombreCompra.text = p.nombre
                    binding.txtDescripcionCompra.text = p.descripcion
                    binding.txtPrecioCompra.text = "${p.precio} €"
                    binding.txtPorcentajeCompra.text = "${p.porcentajeDonacion} %"
                    Glide.with(requireContext())
                        .load("http://192.168.1.160:8080/api/uploads/files/${p.imagen}")
                        .placeholder(R.drawable.ic_placeholder_pink)
                        .into(binding.imgProductoCompra)
                }
            }
        }
    }

    private fun cargarOngs() {
        lifecycleScope.launch {
            val resp = withContext(Dispatchers.IO) { ongApi.obtenerOngs() }
            if (resp.isSuccessful) {
                val lista: List<Ong> = resp.body() ?: emptyList()
                val spinnerAdapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_spinner_item,
                    lista.map { it.nombreOng }
                ).apply { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }
                binding.spinnerOngs.adapter = spinnerAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}