package com.andrea_murillo.involucrate.ui.monedero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentTransaccionBinding
import java.math.BigDecimal

class TransaccionFragment : Fragment() {

    private var _binding: FragmentTransaccionBinding? = null
    private val binding get() = _binding!!

    // Paso de argumento para distinguir ingreso vs retiro
    private val isIngreso: Boolean by lazy {
        arguments?.getBoolean("isIngreso", true) ?: true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransaccionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Ajustar título según tipo de transacción
        val titulo = if (isIngreso) "Retirar dinero" else "Ingresar dinero"
        binding.root.findViewById<TextView>(R.id.txtTituloTransaccion)?.text = titulo

        binding.btnCancelar.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnAceptar.setOnClickListener {
            val cantidadStr = binding.editCantidad.text.toString().trim()
            val numTarj = binding.editNumeroTarjeta.text.toString().trim()
            val fecha = binding.editFechaCaducidad.text.toString().trim()
            val cvc = binding.editCvc.text.toString().trim()

            if (cantidadStr.isEmpty() || numTarj.isEmpty() || fecha.isEmpty() || cvc.isEmpty()) {
                Toast.makeText(requireContext(), "Rellena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val cantidad = try {
                BigDecimal(cantidadStr)
            } catch (e: NumberFormatException) {
                Toast.makeText(requireContext(), "Cantidad inválida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Lógica de actualización de saldo en Monedero
            // Por ahora, simplemente volvemos atrás
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}