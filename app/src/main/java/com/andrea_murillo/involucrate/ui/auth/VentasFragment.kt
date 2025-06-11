package com.andrea_murillo.involucrate.ui.ventas

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentVentasBinding
import com.andrea_murillo.involucrate.model.Producto
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.ProductoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VentasFragment : Fragment() {

    private var _binding: FragmentVentasBinding? = null
    private val binding get() = _binding!!

    private val productoApi: ProductoApi by lazy {
        ApiService.retrofit.create(ProductoApi::class.java)
    }

    private lateinit var adapter: VentasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVentasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewVentas.layoutManager = LinearLayoutManager(requireContext())
        adapter = VentasAdapter(
            onEditClick = { producto ->
                val bundle = Bundle().apply { putLong("productoId", producto.id ?: -1L) }
                findNavController().navigate(R.id.detalleProductoVenta, bundle)
            },
            onDeleteClick = { producto ->
                producto.id?.let { deleteProducto(it) }
            }
        )
        binding.recyclerViewVentas.adapter = adapter

        binding.btnAgregar.setOnClickListener {
            val bundle = Bundle().apply { putLong("productoId", -1L) }
            findNavController().navigate(R.id.detalleProductoVenta, bundle)
        }

        cargarProductos()
    }

    private fun cargarProductos() {
        val userId = requireContext().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            .getLong("usuario_id", -1L)

        if (userId == -1L) return

        lifecycleScope.launch {
            val response = withContext(Dispatchers.IO) {
                productoApi.getProductosDelUsuario(userId)
            }
            if (response.isSuccessful) {
                response.body()?.let { adapter.submitList(it) }
            }
        }
    }

    private fun deleteProducto(id: Long) {
        lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                productoApi.eliminarProducto(id)
            }
            if (result.isSuccessful) {
                cargarProductos()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
