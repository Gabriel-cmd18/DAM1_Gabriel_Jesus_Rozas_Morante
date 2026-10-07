package com.example.appgrupo1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appgrupo1.databinding.ActivityMainBinding

data class Usuario(
    val usuario: String,
    val password: String
)

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    // Fuente de datos simulada
    private val usuarios = listOf(
        Usuario("i202332608", "Futuro1020")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar evento click
        binding.btnIngresar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        if (view?.id == binding.btnIngresar.id) {

            val usuario = binding.etUsuario.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Validación de campos
            if (usuario.isBlank() || password.isBlank()) {

                Toast.makeText(
                    this,
                    "Ingrese usuario y contraseña",
                    Toast.LENGTH_SHORT
                ).show()

                return
            }

            // Buscar credenciales exactas
            val usuarioEncontrado = usuarios.find {
                it.usuario == usuario &&
                        it.password == password
            }

            if (usuarioEncontrado != null) {

                val intent = Intent(
                    this,
                    HomeActivity::class.java
                )

                // Evitar regresar al Login
                intent.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK

                startActivity(intent)

            } else {

                Toast.makeText(
                    this,
                    "Usuario o contraseña incorrectos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}