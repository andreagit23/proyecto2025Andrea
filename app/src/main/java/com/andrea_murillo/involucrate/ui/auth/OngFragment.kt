package com.andrea_murillo.involucrate.ui.ongs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentOngBinding
import com.andrea_murillo.involucrate.model.Ong
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.OngApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OngsFragment : Fragment() {
    private var _binding: FragmentOngBinding? = null
    private val binding get() = _binding!!

    private val ongApi by lazy { ApiService.retrofit.create(OngApi::class.java) }
    private lateinit var adapter: OngsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = FragmentOngBinding.inflate(inflater, container, false).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OngsAdapter { ong ->
            val bundle = Bundle().apply { putLong("ongId", ong.id ?: -1L) }
            findNavController().navigate(R.id.detalleOngFragment, bundle)
        }
        binding.recyclerViewOngs.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewOngs.adapter = adapter

        lifecycleScope.launch {
            val resp = withContext(Dispatchers.IO) { ongApi.obtenerOngs() }
            if (resp.isSuccessful) adapter.submitList(resp.body().orEmpty())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}