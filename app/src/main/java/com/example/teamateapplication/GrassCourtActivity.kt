package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class GrassCourtActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grass_court)

        val buttonHome = findViewById<ImageButton>(R.id.imageButton_home)
        val buttonStar = findViewById<ImageButton>(R.id.imageButton_favourites)
        val buttonSettings = findViewById<ImageButton>(R.id.imageButton_settings)

        val buttonBack = findViewById<ImageButton>(R.id.back)

        buttonBack.setOnClickListener {
            finish()
        }

        buttonHome.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }

        buttonStar.setOnClickListener {
            val intent = Intent(this, PreferitiActivity::class.java)
            startActivity(intent)
        }

        buttonSettings.setOnClickListener {
            val intent = Intent(this, ImpostazioniActivity::class.java)
            startActivity(intent)
        }
    }
}