package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class CareerStatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career_stats)

        // Ricevi i dati dall'Intent
        val playerName = intent.getStringExtra("player_name")
        val flagResId = intent.getStringExtra("player_flag")
        val playerImageResId = intent.getStringExtra("player_image")
        val careerStats  = intent.getParcelableExtra<CareerStats>("career_stats")
        val backgroundResId = intent.getIntExtra("background_res_id", R.drawable.hard)
        val textViewColorResId = intent.getIntExtra("text_view_color_res_id", R.color.medium_high_blue)
        val textToDisplay = intent.getStringExtra("text_to_display") ?: "Superficie"

        // Ottieni gli ID drawable
        val flagDrawableId = resources.getIdentifier(flagResId, "drawable", packageName)
        val playerDrawableId = resources.getIdentifier(playerImageResId, "drawable", packageName)
        val rootLayout = findViewById<ViewGroup>(R.id.root_layout) // Assicurati che questo sia il contenitore principale del layout
        rootLayout.setBackgroundResource(backgroundResId)
        val textViewColor = ContextCompat.getColor(this, textViewColorResId)

        // Imposta i dati nella UI
        findViewById<TextView>(R.id.title_player_informations).text = playerName
        findViewById<ImageView>(R.id.country_img).setImageResource(flagDrawableId)
        findViewById<ImageView>(R.id.player_img).setImageResource(playerDrawableId)
        findViewById<TextView>(R.id.textView_surface).text = textToDisplay


        for (i in 0 until rootLayout.childCount) {
            val view = rootLayout.getChildAt(i)
            if (view is TextView) {
                view.setBackgroundColor(textViewColor)
            }
        }

        careerStats ?.let {
            findViewById<TextView>(R.id.textViewMatchesWon).text = "Partite vinte: ${it.matchesWon}"
            findViewById<TextView>(R.id.textViewMatchesLost).text = "Partite perse: ${it.matchesLost}"
            findViewById<TextView>(R.id.textViewWinRate).text = "Percentuale di vittorie: ${it.winRate}%"
            findViewById<TextView>(R.id.textViewTournamentsWon).text = "Tornei vinti: ${it.tournamentsWon}"
        }

        val buttonHome = findViewById<ImageButton>(R.id.imageButton_home)
        val buttonStar = findViewById<ImageButton>(R.id.imageButton_favourites)
        val buttonSettings = findViewById<ImageButton>(R.id.imageButton_settings)

        val buttonBack = findViewById<ImageButton>(R.id.back)

        buttonBack.setOnClickListener {
            finish()
        }

        buttonHome.setOnClickListener {
            val intent = Intent(this, StatisticsPageActivity::class.java)
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