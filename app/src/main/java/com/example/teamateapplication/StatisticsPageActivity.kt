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
            Player("Jannik Sinner", R.drawable.italia),
            Player("Alexander Zverev", R.drawable.germania),
            Player("Carlos Alcaraz", R.drawable.spagna),
            Player("Taylor Fritz", R.drawable.usa),
            Player("Daniil Medvedev", R.drawable.russia),
            Player("Novak Djokovic", R.drawable.serbia),
            Player("Andrey Rublev", R.drawable.russia),
            Player("Grigor Dimitrov", R.drawable.bulgaria),
            Player("Alex Deminaur", R.drawable.australia),
            Player("Casper Ruud", R.drawable.norvegia)
        )

        // Configura la RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_players)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PlayerAdapter(players)
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
