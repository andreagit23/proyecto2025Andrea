package com.andrea_murillo.involucrate.ui.auth

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentLoginBinding
import com.andrea_murillo.involucrate.model.AuthRequest
import com.andrea_murillo.involucrate.model.AuthResponse
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.AuthApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val authApi: AuthApi by lazy {
        ApiService.retrofit.create(AuthApi::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegistrarse.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }

        binding.btnEntrar.setOnClickListener {
            val correo = binding.editTextUsuario.text.toString()
            val contrasena = binding.editTextContrasena.text.toString()

            if (correo.isNotBlank() && contrasena.isNotBlank()) {
                val request = AuthRequest(correo, contrasena)

                lifecycleScope.launch {
                    try {
                        val response = authApi.login(request)
                        if (response.isSuccessful) {
                            val usuarioId = response.body()?.usuarioId ?: -1L
                            val tipo = if (response.body()?.mensaje?.contains("ONG", true) == true) "ONG" else "USUARIO"

                            // Guardar en SharedPreferences
                            val sharedPref = requireContext().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                            sharedPref.edit().putLong("usuario_id", usuarioId).putString("tipo_usuario", tipo).apply()

                            Toast.makeText(requireContext(), "Login correcto", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_login_to_home)
                            // Redirigir a home (cuando esté disponible)
                        } else {
                            Log.e("LOGIN_ERROR", "Código ${response.code()}: ${response.errorBody()?.string()}")
                            Toast.makeText(requireContext(), "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        Log.e("LOGIN_EXCEPTION", "Falló la conexión", e)
                        Toast.makeText(requireContext(), "ERROR: ${e.message}", Toast.LENGTH_LONG).show()
                    }
                }

            } else {
                Toast.makeText(requireContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
