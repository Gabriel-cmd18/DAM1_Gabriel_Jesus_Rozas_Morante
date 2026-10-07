package com.example.appgrupo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.appgrupo1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mostrar Pregunta 1 al ingresar
        cargarFragmento(Pregunta1Fragment())

        // Eventos del BottomNavigationView
        binding.bottomNavigation.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_pregunta1 -> {
                    cargarFragmento(Pregunta1Fragment())
                    true
                }

                R.id.nav_pregunta2 -> {
                    cargarFragmento(Pregunta2Fragment())
                    true
                }

                R.id.nav_pregunta3 -> {
                    cargarFragmento(Pregunta3Fragment())
                    true
                }

                R.id.nav_pregunta4 -> {
                    cargarFragmento(Pregunta4Fragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun cargarFragmento(fragmento: Fragment) {

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.contenedorFragmentos,
                fragmento
            )
            .commit()
    }
}