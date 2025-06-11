package com.andrea_murillo.involucrate.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentRegistroBinding
import com.andrea_murillo.involucrate.model.Usuario
import com.andrea_murillo.involucrate.model.Ong
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.AuthApi
import com.andrea_murillo.involucrate.network.UsuarioApi
import com.andrea_murillo.involucrate.utils.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistroFragment : Fragment() {

    private var _binding: FragmentRegistroBinding? = null
    private val binding get() = _binding!!

    private val authApi: AuthApi by lazy {
        ApiService.retrofit.create(AuthApi::class.java)
    }

    private val usuarioApi: UsuarioApi by lazy {
        ApiService.retrofit.create(UsuarioApi::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spinnerTipo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val isOng = parent.getItemAtPosition(position).toString().equals("ONG", ignoreCase = true)
                val visibility = if (isOng) View.VISIBLE else View.GONE

                binding.editNombreOng.visibility = visibility
                binding.editDescripcionOng.visibility = visibility
                binding.editDireccionOng.visibility = visibility
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.btnConfirmarRegistro.setOnClickListener {
            val tipo = binding.spinnerTipo.selectedItem.toString()
            val nombre = binding.editNombre.text.toString()
            val apellidos = binding.editApellidos.text.toString()
            val correo = binding.editCorreo.text.toString()
            val telefono = binding.editTelefono.text.toString()
            val dni = binding.editDni.text.toString()
            val contrasena = binding.editContrasena.text.toString()

            if (nombre.isBlank() || apellidos.isBlank() || correo.isBlank() || telefono.isBlank() || dni.isBlank() || contrasena.isBlank()) {
                Toast.makeText(requireContext(), "Rellena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuario = Usuario(
                nombre = nombre,
                apellidos = apellidos,
                correoElectronico = correo,
                telefono = telefono,
                dni = dni,
                hashContrasena = contrasena,
                tipo = tipo.uppercase()
            )

            lifecycleScope.launch {
                try {
                    val userResponse = withContext(Dispatchers.IO) {
                        authApi.register(usuario)
                    }

                    if (userResponse.isSuccessful) {
                        val user = userResponse.body()
                        if (tipo.equals("ONG", ignoreCase = true) && user != null) {
                            val ong = Ong(
                                usuario = user,
                                nombreOng = binding.editNombreOng.text.toString(),
                                descripcion = binding.editDescripcionOng.text.toString(),
                                direccion = binding.editDireccionOng.text.toString(),
                                telefono = user.telefono,
                                correoElectronico = user.correoElectronico)

                            val ongResponse = withContext(Dispatchers.IO) {
                                authApi.registerOng(ong)
                            }

                            if (!ongResponse.isSuccessful) {
                                Toast.makeText(requireContext(), "Usuario registrado pero ONG falló", Toast.LENGTH_SHORT).show()
                                return@launch
                            }
                        }

                        val sessionManager = SessionManager(requireContext())
                        sessionManager.saveSession(user!!.id!!, tipo.equals("ONG", ignoreCase = true))

                        Toast.makeText(requireContext(), "Registro exitoso", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_registroFragment_to_loginFragment)
                    } else {
                        Toast.makeText(requireContext(), "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(requireContext(), "Error de red", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
