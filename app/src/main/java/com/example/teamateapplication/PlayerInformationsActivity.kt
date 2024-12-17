package com.example.teamateapplication

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
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

        val selectedPlayerName = intent.getStringExtra("player_name")
        // Carico i dati dal JSON
        val players = loadPlayersFromJson(this)

        val selectedPlayer = players.firstOrNull { it.name == selectedPlayerName }

        if (selectedPlayer == null) {
            Log.e("PlayerInfo", "Giocatore non trovato: $selectedPlayerName")
            finish() // Torno indietro se non trovo il giocatore
            return
        }

        // Ricevo i dati passati dall'Intent
        findViewById<TextView>(R.id.title_player_informations).text = selectedPlayer.name
        val flagDrawableId = resources.getIdentifier(selectedPlayer.flagResId, "drawable", packageName)
        val playerDrawableId = resources.getIdentifier(selectedPlayer.imageResId, "drawable", packageName)

        // Trovo le viste nel layout
        findViewById<ImageView>(R.id.country_img).setImageResource(flagDrawableId)
        findViewById<ImageView>(R.id.player_img).setImageResource(playerDrawableId)

        findViewById<TextView>(R.id.player_age).text = "Età: ${selectedPlayer.playerInfo.age}"
        findViewById<TextView>(R.id.player_nationality).text = "Nazionalità: ${selectedPlayer.playerInfo.nationality}"
        findViewById<TextView>(R.id.player_height).text = "Altezza: ${selectedPlayer.playerInfo.height} cm"
        findViewById<TextView>(R.id.player_weight).text = "Peso: ${selectedPlayer.playerInfo.weight} kg"

        buttonInfoPlayer = findViewById(R.id.info_player)
        buttonStatsPlayer = findViewById(R.id.stats_player)
        buttonStatsCareer = findViewById(R.id.stats_career)
        buttonLastNews = findViewById(R.id.button_last_news)

        buttonList = listOf(buttonInfoPlayer, buttonStatsPlayer, buttonStatsCareer, buttonLastNews)

        // Imposto i listener per i bottoni
        buttonInfoPlayer.setOnClickListener {
            resetButtonBackgrounds()
            buttonInfoPlayer.setBackgroundColor(getColor(R.color.dark_blue))
            clearFragmentContainer()
        }

        buttonStatsPlayer.setOnClickListener {
            selectedPlayer?.let { player ->
                // Creo il fragment con le playerStats
                val fragment = StatisticsPlayerFragment.newInstance(player.playerStats)

                // Sostituisco il fragment nel container
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit()
            } ?: run {
                Log.e("PlayerInfo", "Giocatore non trovato")
            }
            updateButtonBackground(buttonStatsPlayer)
        }

        buttonStatsCareer.setOnClickListener {
            val statsFragment = StatisticsCareerFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("selected_player", selectedPlayer)
                }
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, statsFragment)
                .commit()
            updateButtonBackground(buttonStatsCareer)
        }

        buttonLastNews.setOnClickListener {
            loadFragment(LastNewsFragment())
            updateButtonBackground(buttonLastNews)
        }

        val buttonHome = findViewById<ImageButton>(R.id.imageButton_home)

        buttonHome.setOnClickListener {
            val intent = Intent(this, StatisticsPageActivity::class.java)
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

    // Funzione dove sostituisco il Fragment nel container
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    // Funzione dove aggiornarno lo sfondo dei bottoni
    private fun updateButtonBackground(selectedButton: Button) {
        // Resetta gli sfondi dei bottoni
        resetButtonBackgrounds()
        // Imposto uno sfondo diverso per il bottone selezionato
        selectedButton.setBackgroundColor(getColor(R.color.dark_blue))
    }

    // Funzione dove resetto gli sfondi di tutti i bottoni
    private fun resetButtonBackgrounds() {
        for (button in buttonList) {
            button.setBackgroundColor(getColor(R.color.light_blue))
        }
    }

    // Funzione dove rimuovo i fragment
    private fun clearFragmentContainer() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, Fragment())
            .commit()
    }
}