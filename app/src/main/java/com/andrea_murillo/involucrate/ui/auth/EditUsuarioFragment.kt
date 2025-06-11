package com.andrea_murillo.involucrate.ui.usuario

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentEditUsuarioBinding
import com.andrea_murillo.involucrate.model.AuthRequest
import com.andrea_murillo.involucrate.model.AuthResponse
import com.andrea_murillo.involucrate.model.Usuario
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.AuthApi
import com.andrea_murillo.involucrate.network.UsuarioApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditUsuarioFragment : Fragment() {

    private var _binding: FragmentEditUsuarioBinding? = null
    private val binding get() = _binding!!

    private val usuarioApi by lazy {
        ApiService.retrofit.create(UsuarioApi::class.java)
    }
    private val authApi by lazy {
        ApiService.retrofit.create(AuthApi::class.java)
    }
    private var originalUsuario: Usuario? = null
    private var usuarioId: Long = -1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuarioId = requireContext()
            .getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            .getLong("usuario_id", -1L)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cargarDatosUsuario()

        binding.btnCancelar.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnActualizar.setOnClickListener {
            actualizarUsuario()
        }
    }

    private fun cargarDatosUsuario() {
        lifecycleScope.launch {
            val resp = withContext(Dispatchers.IO) {
                usuarioApi.getUserById(usuarioId)
            }
            if (resp.isSuccessful) {
                originalUsuario = resp.body()
                originalUsuario?.let { u ->
                    binding.editNombre.setText(u.nombre)
                    binding.editApellidos.setText(u.apellidos)
                    binding.editDni.setText(u.dni)
                    binding.editCorreo.setText(u.correoElectronico)
                    binding.editTelefono.setText(u.telefono)
                }
            } else {
                Toast.makeText(requireContext(), "Error cargando datos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun actualizarUsuario() {
        val nombre = binding.editNombre.text.toString().trim()
        val apellidos = binding.editApellidos.text.toString().trim()
        val dni = binding.editDni.text.toString().trim()
        val correo = binding.editCorreo.text.toString().trim()
        val telefono = binding.editTelefono.text.toString().trim()
        val pwdActual = binding.editContrasenaActual.text.toString().trim()
        val pwdNueva = binding.editNuevaContrasena.text.toString().trim()
        val pwdConf  = binding.editConfirmarContrasena.text.toString().trim()

        if (nombre.isEmpty() || apellidos.isEmpty() ||
            dni.isEmpty() || correo.isEmpty() ||
            telefono.isEmpty() || pwdActual.isEmpty()
        ) {
            Toast.makeText(requireContext(), "Completa todos los campos obligatorios", Toast.LENGTH_SHORT).show()
            return
        }
        if (pwdNueva.isNotEmpty() && pwdNueva != pwdConf) {
            Toast.makeText(requireContext(), "La nueva contraseña no coincide", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            // 1) Verificar contraseña actual
            val correoOriginal = originalUsuario?.correoElectronico ?: return@launch
            val loginResp = withContext(Dispatchers.IO) {
                authApi.login(AuthRequest(correoElectronico = correoOriginal, contrasena = pwdActual))
            }
            if (!loginResp.isSuccessful) {
                Toast.makeText(requireContext(), "Contraseña actual incorrecta", Toast.LENGTH_SHORT).show()
                return@launch
            }
            // 2) Construir objeto actualizado
            val orig = originalUsuario!!
            val usuarioUpdate = Usuario(
                id = orig.id,
                nombre = nombre,
                apellidos = apellidos,
                dni = dni,
                correoElectronico = correo,
                hashContrasena = if (pwdNueva.isNotEmpty()) pwdNueva else orig.hashContrasena,
                tipo = orig.tipo,
                telefono = telefono,
                estadoCuenta = orig.estadoCuenta
            )
            // 3) Llamar PUT /usuarios/{id}
            val updateResp = withContext(Dispatchers.IO) {
                usuarioApi.updateUser(usuarioId, usuarioUpdate)
            }
            if (updateResp.isSuccessful) {
                Toast.makeText(requireContext(), "Datos actualizados", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            } else {
                Toast.makeText(requireContext(), "Error al actualizar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
