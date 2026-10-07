package com.example.appgrupo1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pregunta3Fragment : Fragment() {

    private lateinit var rvPaises: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(
            R.layout.fragment_p_pregunta3,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        rvPaises = view.findViewById(R.id.rvPaises)

        val listaPaises = listOf(

            Pais(
                "España",
                "https://flagcdn.com/w320/es.png"
            ),

            Pais(
                "Francia",
                "https://flagcdn.com/w320/fr.png"
            ),

            Pais(
                "Italia",
                "https://flagcdn.com/w320/it.png"
            ),

            Pais(
                "Alemania",
                "https://flagcdn.com/w320/de.png"
            ),

            Pais(
                "Portugal",
                "https://flagcdn.com/w320/pt.png"
            ),

            Pais(
                "Países Bajos",
                "https://flagcdn.com/w320/nl.png"
            ),

            Pais(
                "Bélgica",
                "https://flagcdn.com/w320/be.png"
            ),

            Pais(
                "Suiza",
                "https://flagcdn.com/w320/ch.png"
            ),

            Pais(
                "Austria",
                "https://flagcdn.com/w320/at.png"
            ),

            Pais(
                "Grecia",
                "https://flagcdn.com/w320/gr.png"
            ),

            Pais(
                "Noruega",
                "https://flagcdn.com/w320/no.png"
            ),

            Pais(
                "Suecia",
                "https://flagcdn.com/w320/se.png"
            ),

            Pais(
                "Finlandia",
                "https://flagcdn.com/w320/fi.png"
            ),

            Pais(
                "Dinamarca",
                "https://flagcdn.com/w320/dk.png"
            ),

            Pais(
                "Islandia",
                "https://flagcdn.com/w320/is.png"
            ),

            Pais(
                "Irlanda",
                "https://flagcdn.com/w320/ie.png"
            ),

            Pais(
                "Polonia",
                "https://flagcdn.com/w320/pl.png"
            ),

            Pais(
                "República Checa",
                "https://flagcdn.com/w320/cz.png"
            ),

            Pais(
                "Hungría",
                "https://flagcdn.com/w320/hu.png"
            ),

            Pais(
                "Rumanía",
                "https://flagcdn.com/w320/ro.png"
            )
        )

        rvPaises.layoutManager = LinearLayoutManager(requireContext())
        rvPaises.adapter = PaisAdapter(listaPaises)
    }
}