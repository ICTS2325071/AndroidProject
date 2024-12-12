package com.example.teamateapplication

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class PlayerInformationsActivity : AppCompatActivity() {

    private lateinit var buttonInfoPlayer: Button
    private lateinit var buttonStatsPlayer: Button
    private lateinit var buttonStatsCareer: Button
    private lateinit var buttonLastNews: Button
    private lateinit var buttonList: List<Button>

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

        // Riferimenti ai bottoni
        buttonInfoPlayer = findViewById(R.id.info_player)
        buttonStatsPlayer = findViewById(R.id.stats_player)
        buttonStatsCareer = findViewById(R.id.stats_career)
        buttonLastNews = findViewById(R.id.button_last_news)

        // Lista dei bottoni per facilitarne la gestione
        buttonList = listOf(buttonInfoPlayer, buttonStatsPlayer, buttonStatsCareer, buttonLastNews)

        // Imposta i listener per i bottoni
        buttonInfoPlayer.setOnClickListener {
            resetButtonBackgrounds()
            buttonInfoPlayer.setBackgroundColor(getColor(R.color.dark_blue)) // Colore speciale
            clearFragmentContainer()
        }

        buttonStatsPlayer.setOnClickListener {
            loadFragment(StatisticsPlayerFragment())
            updateButtonBackground(buttonStatsPlayer)
        }

        buttonStatsCareer.setOnClickListener {
            loadFragment(StatisticsCareerFragment())
            updateButtonBackground(buttonStatsCareer)
        }

        buttonLastNews.setOnClickListener {
            loadFragment(LastNewsFragment())
            updateButtonBackground(buttonLastNews)
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
            .commit()
    }

    // Funzione per aggiornare lo sfondo dei bottoni
    private fun updateButtonBackground(selectedButton: Button) {
        // Resetta gli sfondi dei bottoni
        resetButtonBackgrounds()
        // Imposta uno sfondo diverso per il bottone selezionato
        selectedButton.setBackgroundColor(getColor(R.color.dark_blue))
    }

    // Funzione per resettare gli sfondi di tutti i bottoni
    private fun resetButtonBackgrounds() {
        for (button in buttonList) {
            button.setBackgroundColor(getColor(R.color.light_blue)) // Colore di default
        }
    }

    // Funzione per rimuovere i fragment
    private fun clearFragmentContainer() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, Fragment()) // Fragment vuoto
            .commit()
    }
}