package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val MAX_INTENTOS = 3
    private var intentosActuales = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre: EditText = findViewById(R.id.nombre)
        val contra: EditText = findViewById(R.id.contra)
        val btnLogin: Button = findViewById(R.id.login)
        val btnRegistrarse: Button = findViewById(R.id.regis)

        // Botón para iniciar sesión
        btnLogin.setOnClickListener {
            val nombreText = nombre.text.toString()
            val contraseña = contra.text.toString()

            if (validarCredenciales(nombreText, contraseña)) {
                val intent = Intent(this, Bienvenido::class.java)
                startActivity(intent)
            } else {
                intentosActuales++
                if (intentosActuales >= MAX_INTENTOS) {
                    mostrarAlerta("Demasiados intentos, ¿desea cerrar la aplicación?")
                } else {
                    mostrarAlerta("Credenciales incorrectas. Intento $intentosActuales de $MAX_INTENTOS")
                }
            }
        }

        // Botón para registrarse
        btnRegistrarse.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }

    // Función de ejemplo para validar las credenciales (deberías implementar la lógica real)
    private fun validarCredenciales(nombre: String, contraseña: String): Boolean {
        // Lógica de autenticación ficticia (solo para el ejemplo)
        return nombre == "usuario" && contraseña == "contraseña"
    }

    private fun mostrarAlerta(mensaje: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(mensaje)
            .setPositiveButton("Aceptar") { _, _ ->
                if (mensaje.contains("Demasiados intentos")) {
                    // Cerrar la aplicación solo si se presiona Aceptar en la alerta de "Demasiados intentos"
                    finish()
                }
            }
            .setNegativeButton("Cancelar", null)
        builder.create().show()
    }
}