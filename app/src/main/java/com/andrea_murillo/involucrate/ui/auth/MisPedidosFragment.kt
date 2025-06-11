package com.andrea_murillo.involucrate.ui.pedidos

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrea_murillo.involucrate.databinding.FragmentMisPedidosBinding
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.PedidoApi
import com.andrea_murillo.involucrate.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MisPedidosFragment : Fragment() {
    private var _binding: FragmentMisPedidosBinding? = null
    private val binding get() = _binding!!
    private val pedidoApi by lazy { ApiService.retrofit.create(PedidoApi::class.java) }
    private var usuarioId: Long = -1L
    private lateinit var adapter: PedidosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuarioId = requireContext()
            .getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            .getLong("usuario_id", -1L)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentMisPedidosBinding.inflate(inflater, container, false).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PedidosAdapter { pedido ->
            val bundle = Bundle().apply { putLong("pedidoId", pedido.id ?: -1L) }
            findNavController().navigate(R.id.detallePedido, bundle)
        }
        binding.recyclerViewPedidos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPedidos.adapter = adapter

        lifecycleScope.launch {
            val resp = withContext(Dispatchers.IO) { pedidoApi.listarPedidosUsuario(usuarioId) }
            if (resp.isSuccessful) adapter.submitList(resp.body().orEmpty())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}