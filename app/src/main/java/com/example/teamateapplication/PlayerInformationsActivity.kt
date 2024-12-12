package com.example.teamateapplication

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class PlayerInformationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_informations)

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

        val buttonStatsPlayer = findViewById<Button>(R.id.stats_player)

        buttonStatsPlayer.setOnClickListener {
            loadFragment(StatisticsPlayerFragment())
        }

        val buttonStatsCareer = findViewById<Button>(R.id.stats_career)

        buttonStatsCareer.setOnClickListener {
            loadFragment(StatisticsCareerFragment())
        }

        val buttonLastNews = findViewById<Button>(R.id.button_last_news)

        buttonLastNews.setOnClickListener {
            loadFragment(LastNewsFragment())
        }

        val buttonHome = findViewById<ImageButton>(R.id.imageButton_home)

        buttonHome.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }

        val buttonStar = findViewById<ImageButton>(R.id.imageButton_favourites)

        buttonStar.setOnClickListener {
            val intent = Intent(this, PreferitiActivity::class.java)
            startActivity(intent)
        }

        val buttonSettings = findViewById<ImageButton>(R.id.imageButton_settings)

        buttonSettings.setOnClickListener {
            val intent = Intent(this, ImpostazioniActivity::class.java)
            startActivity(intent)
        }

        val buttonBack = findViewById<ImageButton>(R.id.back)

        buttonBack.setOnClickListener {
            val intent = Intent(this, StatisticsPageActivity::class.java)
            startActivity(intent)
        }
    }

    // Funzione per sostituire il Fragment nel container
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}