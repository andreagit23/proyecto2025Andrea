package com.andrea_murillo.involucrate.ui.pedidos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentDetallePedidoBinding
import com.andrea_murillo.involucrate.model.Pedido
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.PedidoApi
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.NumberFormat
import java.util.Locale

class DetallePedidoFragment : Fragment() {

    private var _binding: FragmentDetallePedidoBinding? = null
    private val binding get() = _binding!!

    // Obtiene el pedidoId desde los argumentos
    private val pedidoId: Long by lazy {
        requireArguments().getLong("pedidoId", -1L)
    }

    private val pedidoApi by lazy {
        ApiService.retrofit.create(PedidoApi::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetallePedidoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cargarPedido()
        binding.btnMarcarRecibido.setOnClickListener {
            Toast.makeText(requireContext(), "Funcionalidad pendiente", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cargarPedido() {
        lifecycleScope.launch {
            val resp = withContext(Dispatchers.IO) {
                pedidoApi.obtenerPedidoPorId(pedidoId)
            }
            if (resp.isSuccessful) {
                resp.body()?.let { pedido ->
                    bindPedido(pedido)
                }
            } else {
                Toast.makeText(requireContext(), "Error al cargar pedido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun bindPedido(p: Pedido) {
        // Imagen
        Glide.with(requireContext())
            .load("http://192.168.1.160:8080/api/uploads/files/${p.producto.imagen}")
            .placeholder(R.drawable.ic_placeholder_pink)
            .into(binding.imgProductoPedido)

        // Nombre y descripción
        binding.txtNombrePedido.text = p.producto.nombre
        binding.txtDescripcionPedido.text = p.producto.descripcion

        // Categoría
        binding.txtCategoriaPedido.text = p.producto.categoria.nombre

        // Estado del pedido
        binding.txtEstadoPedido.text = p.estado.name

        // Porcentaje destinado
        binding.txtPorcentajePedido.text = "${p.producto.porcentajeDonacion}%"

        // Precio total formateado
        val nf = NumberFormat.getCurrencyInstance(Locale.getDefault())
        binding.txtPrecioTotal.text = nf.format(p.precioTotal)

        // ONG destinataria
        binding.txtOngPedido.text = p.ong.nombreOng
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
