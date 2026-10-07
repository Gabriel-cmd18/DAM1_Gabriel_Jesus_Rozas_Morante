package com.example.appgrupo1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.appgrupo1.databinding.FragmentPregunta1Binding
import java.util.Locale

class Pregunta1Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPregunta1Binding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        // Evento del botón
        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        if (view?.id == binding.btnCalcular.id) {

            val textoLongitud =
                binding.etLongitud.text.toString().trim()

            // Validar campo vacío
            if (textoLongitud.isBlank()) {

                Toast.makeText(
                    requireContext(),
                    "Ingrese la longitud de la carga",
                    Toast.LENGTH_SHORT
                ).show()

                return
            }

            val longitud = textoLongitud.toDoubleOrNull()

            // Validar número
            if (longitud == null || longitud < 0) {

                Toast.makeText(
                    requireContext(),
                    "Ingrese una longitud válida",
                    Toast.LENGTH_SHORT
                ).show()

                return
            }

            // Longitud máxima permitida
            val longitudMaxima = 12.0

            if (longitud <= longitudMaxima) {

                binding.tvResultado.text =
                    "Carga dentro de las dimensiones permitidas."

            } else {

                val exceso = longitud - longitudMaxima

                val sobrecargo =
                    400.00 + (exceso * 120.00)

                binding.tvResultado.text = String.format(
                    Locale.US,
                    "Longitud ingresada: %.2f m\n" +
                            "Exceso de metros: %.2f m\n" +
                            "Sobrecargo total: S/ %.2f",
                    longitud,
                    exceso,
                    sobrecargo
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}