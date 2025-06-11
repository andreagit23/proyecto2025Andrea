package com.andrea_murillo.involucrate.ui.home

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
import com.andrea_murillo.involucrate.databinding.FragmentHomeBinding
import com.andrea_murillo.involucrate.model.Usuario
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.UsuarioApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val usuarioApi: UsuarioApi by lazy {
        ApiService.retrofit.create(UsuarioApi::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireContext().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val userId = sharedPref.getLong("usuario_id", -1)

        if (userId != -1L) {
            lifecycleScope.launch {
                try {
                    val response = withContext(Dispatchers.IO) {
                        usuarioApi.getUserById(userId)
                    }
                    if (response.isSuccessful) {
                        val user = response.body()
                        user?.let {
                            binding.textSaludo.text = "¡Hola, ${it.nombre}!"
                            sharedPref.edit().putString("usuario_nombre", it.nombre).apply()

                            val isOng = it.tipo.equals("ONG", ignoreCase = true)
                            updateMenuVisibility(isOng)
                        }
                    }
                } catch (_: Exception) {}
            }
        }
        binding.btnVender.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_ventasFragment)
        }
        binding.btnComprar.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_comprasFragment)
        }
        binding.btnPedidos.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_misPedidosFragment)
        }
        binding.btnMonedero.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_monederoFragment)
        }
        binding.btnOngs.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_ongsFragment)
        }
        binding.iconProfile.setOnClickListener {
            val userId = sharedPref.getLong("usuario_id", -1L)
            val bundle = bundleOf("usuarioId" to userId)
            findNavController().navigate(
                R.id.action_home_to_editUsuario,
                bundle
            )
        }
        binding.btnNuestraInformacion.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_nuestraInformacionFragment)
        }
    }

    private fun updateMenuVisibility(isOng: Boolean) {
        with(binding) {
            btnComprar.visibility = if (isOng) View.GONE else View.VISIBLE
            btnVender.visibility = if (isOng) View.GONE else View.VISIBLE
            btnPedidos.visibility = if (isOng) View.GONE else View.VISIBLE
            btnNuestraInformacion.visibility = if (isOng) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
