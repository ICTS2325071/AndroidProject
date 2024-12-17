package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StatisticsPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics_page)

        val players = loadPlayersFromJson(this) // Funzione dove carico i giocatori

        // verifico che i giocatori siano stati caricati correttamente
        Log.d("JSON", players.toString())

        // Configuro la RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_players)

        val adapter = PlayerAdapter(
            this,
            players,
            PlayerInformationsActivity::class.java
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Configuro il filtro sull'EditText
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


        val buttonStar = findViewById<ImageButton>(R.id.imageButton_favourites)
        val buttonSettings = findViewById<ImageButton>(R.id.imageButton_settings)


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
