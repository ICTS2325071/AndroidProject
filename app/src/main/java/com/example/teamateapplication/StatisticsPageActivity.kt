package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StatisticsPageActivity : AppCompatActivity() {

    private lateinit var adapter: PlayerAdapter
    private lateinit var players: List<Player>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics_page)

        // Lista dei giocatori
        players = listOf(
            Player("Jannik Sinner", R.drawable.italia, R.drawable.jannik_sinner),
            Player("Alexander Zverev", R.drawable.germania, R.drawable.alexander_zverev),
            Player("Carlos Alcaraz", R.drawable.spagna, R.drawable.carlos_alcaraz),
            Player("Taylor Fritz", R.drawable.usa, R.drawable.taylor_fritz),
            Player("Daniil Medvedev", R.drawable.russia, R.drawable.daniil_medvedev),
            Player("Novak Djokovic", R.drawable.serbia, R.drawable.novak_djokovic),
            Player("Andrey Rublev", R.drawable.russia, R.drawable.andrey_rublev),
            Player("Grigor Dimitrov", R.drawable.bulgaria, R.drawable.grigor_dimitrov),
            Player("Alex Deminaur", R.drawable.australia, R.drawable.alex_deminaur),
            Player("Casper Ruud", R.drawable.norvegia, R.drawable.casper_ruud)
        )

        // Configura la RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_players)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PlayerAdapter(players) { player ->
            // Apri l'altra Activity
            val intent = Intent(this, PlayerInformationsActivity::class.java)
            // Passa dati alla nuova Activity
            intent.putExtra("player_name", player.name)
            intent.putExtra("player_country", player.flagResId)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        // Configura il filtro sull'EditText
        val editTextSearch = findViewById<EditText>(R.id.editText_search)
        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().lowercase()
                val filteredPlayers = players.filter { it.name.lowercase().contains(query) }
                adapter.updateList(filteredPlayers)
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        val buttonHome = findViewById<ImageButton>(R.id.imageButton_home)
        val buttonStar = findViewById<ImageButton>(R.id.imageButton_favourites)
        val buttonSettings = findViewById<ImageButton>(R.id.imageButton_settings)

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
