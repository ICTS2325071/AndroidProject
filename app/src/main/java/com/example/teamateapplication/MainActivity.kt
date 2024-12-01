package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Trova la TextView dal layout
        val textViewSubtitle: TextView = findViewById(R.id.textView_subtitle)

        // Imposta il click listener
        textViewSubtitle.setOnClickListener {
            // Crea un Intent per avviare la SecondActivity
            val intent = Intent(this, HomeLoginActivity::class.java)
            startActivity(intent)
        }
    }
}