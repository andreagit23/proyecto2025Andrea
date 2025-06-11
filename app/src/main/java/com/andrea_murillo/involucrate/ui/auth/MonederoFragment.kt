package com.andrea_murillo.involucrate.ui.monedero

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentMonederoBinding
import com.andrea_murillo.involucrate.model.Monedero
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.MonederoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.NumberFormat

class MonederoFragment : Fragment() {

    private var _binding: FragmentMonederoBinding? = null
    private val binding get() = _binding!!

    private val monederoApi by lazy {
        ApiService.retrofit.create(MonederoApi::class.java)
    }

    private var usuarioId: Long = -1L
    private var monederoActual: Monedero? = null  // para conservar el ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuarioId = requireContext()
            .getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            .getLong("usuario_id", -1L)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMonederoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cargarSaldo()

        binding.btnIngresar.setOnClickListener {
            findNavController().navigate(R.id.action_monedero_to_transaccion)
        }
        binding.btnRetirar.setOnClickListener {
            findNavController().navigate(R.id.action_monedero_to_transaccion)
        }
    }

    private fun cargarSaldo() {
        lifecycleScope.launch {
            val resp = withContext(Dispatchers.IO) {
                monederoApi.obtenerMonedero(usuarioId)
            }
            if (resp.isSuccessful) {
                resp.body()?.also { m ->
                    monederoActual = m
                    val formato = NumberFormat.getCurrencyInstance().apply {
                        maximumFractionDigits = 2
                    }
                    binding.txtSaldo.text = formato.format(m.cantidad)
                }
            } else {
                binding.txtSaldo.text = "0.00 €"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
