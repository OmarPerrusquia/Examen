package com.example.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Bienvenido : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)



        val btnRegresar:Button=findViewById(R.id.regresar)

        btnRegresar.setOnClickListener {
            var regresar=Intent(this,MainActivity::class.java)
            startActivity(regresar)
        }



    }
}