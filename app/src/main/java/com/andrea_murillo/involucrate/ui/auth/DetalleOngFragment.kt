package com.andrea_murillo.involucrate.ui.ongs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentDetalleOngBinding
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.OngApi
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetalleOngFragment : Fragment() {
    private var _binding: FragmentDetalleOngBinding? = null
    private val binding get() = _binding!!
    private val ongApi by lazy { ApiService.retrofit.create(OngApi::class.java) }
    private val ongId by lazy { requireArguments().getLong("ongId", -1L) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentDetalleOngBinding.inflate(inflater, container, false).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            val resp = withContext(Dispatchers.IO) { ongApi.obtenerOngs() }
            resp.body()?.firstOrNull { it.id == ongId }?.let { ong ->
                Glide.with(requireContext())
                    .load("http://192.168.1.160:8080/api/uploads/files/${ong.imagen}")
                    .placeholder(R.drawable.ic_placeholder_pink)
                    .into(binding.imgOngDetalle)
                binding.txtNombreOngDetalle.text = ong.nombreOng
                binding.txtDescripcionOngDetalle.text = ong.descripcion
                binding.txtDireccionOngDetalle.text = ong.direccion
                binding.txtTelefonoOngDetalle.text = ong.telefono
                binding.txtUrlOngDetalle.text = ong.url
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}