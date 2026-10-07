package com.example.appgrupo1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.appgrupo1.databinding.FragmentPregunta2Binding
import java.util.Locale

class Pregunta2Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPregunta2Binding.inflate(
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

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        if (view?.id == binding.btnCalcular.id) {

            val textoDias =
                binding.etDias.text.toString().trim()

            if (textoDias.isBlank()) {

                Toast.makeText(
                    requireContext(),
                    "Ingrese la cantidad de días",
                    Toast.LENGTH_SHORT
                ).show()

                return
            }

            val dias = textoDias.toIntOrNull()

            if (dias == null || dias < 0) {

                Toast.makeText(
                    requireContext(),
                    "Ingrese una cantidad de días válida",
                    Toast.LENGTH_SHORT
                ).show()

                return
            }

            val diasLibres = 7

            if (dias <= diasLibres) {

                binding.tvResultado.text =
                    "Contenedor retornado dentro de los días libres."

            } else {

                val diasMora = dias - diasLibres

                val demurrage =
                    200.00 + (diasMora * 75.00)

                binding.tvResultado.text = String.format(
                    Locale.US,
                    "Días totales: %d\n" +
                            "Días de mora: %d\n" +
                            "Demurrage total: S/ %.2f",
                    dias,
                    diasMora,
                    demurrage
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}