package com.danielsapplication.app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DescripcionDia : AppCompatActivity() {
    private var emocionesDelDia: List<Emocion>? = null
    private lateinit var list: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion_dia)

        list = findViewById(R.id.listEmocionesDia)
        emocionesDelDia = intent.getSerializableExtra("EmocionesDia") as? List<Emocion>

        llenarListaEmocionesDia()

        if (emocionesDelDia != null) {
            val fechaTextView = findViewById<TextView>(R.id.fechaTv)
            fechaTextView.setText(emocionesDelDia!!.get(0).fecha)
        }



        val btnCalendar = findViewById<Button>(R.id.btnCalendar)
        btnCalendar.setOnClickListener { v ->
            val intent = Intent(v.context, Calendario::class.java)
            startActivity(intent)
        }
    }

    private fun llenarListaEmocionesDia() {
        emocionesDelDia?.forEach { emocion ->
            addEmocionDia(emocion, list)
        } ?: run {
            Toast.makeText(this, "No se recibieron emociones", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addEmocionDia(emocionDia: Emocion, listEmocionesDia: LinearLayout) {
        val inflater = LayoutInflater.from(this)
        val vista = inflater.inflate(R.layout.descripcion_dia_view, null)

        val imgEmocion = vista.findViewById<ImageView>(R.id.ivEmotion)
        val emocion = vista.findViewById<TextView>(R.id.tvEmotion)
        val descripcion = vista.findViewById<TextView>(R.id.tvDescripcion)
        val intensidad = vista.findViewById<TextView>(R.id.tvIntensidad)

        imgEmocion.setImageResource(emocionDia.img)
        emocion.text = emocionDia.emocion
        descripcion.text = emocionDia.descripcion
        intensidad.text = emocionDia.intensidad.toString()

        listEmocionesDia.addView(vista)
    }
}
