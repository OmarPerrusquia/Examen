package com.example.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        val nombre1: EditText = findViewById(R.id.nombre1)
        val contra1: EditText = findViewById(R.id.contra1)
        val btncontinuar: Button = findViewById(R.id.Continuar)
        val btnVolver: Button = findViewById(R.id.regresar1)


        btncontinuar.setOnClickListener {

            val continuar:Intent=Intent(this,Bienvenido::class.java)
            startActivity(continuar)
        }

        btnVolver.setOnClickListener {

            val volver:Intent=Intent(this,AppCompatActivity::class.java)
        }




    }
}