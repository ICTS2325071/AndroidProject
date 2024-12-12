package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HardCourtActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hard_court)

        // Ricevi i dati passati dall'Intent
        val playerName = intent.getStringExtra("player_name")
        val playerCountry = intent.getIntExtra("player_country", 0)
        val playerImageResId = intent.getIntExtra("player_image", 0)
        // Trova le viste nel layout
        val textViewDetail = findViewById<TextView>(R.id.title_player_informations)
        val imageViewCountry = findViewById<ImageView>(R.id.country_img)
        val imageViewPlayer = findViewById<ImageView>(R.id.player_img)
        // Imposta i valori nelle viste
        textViewDetail.text = playerName
        imageViewCountry.setImageResource(playerCountry)
        imageViewPlayer.setImageResource(playerImageResId)

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