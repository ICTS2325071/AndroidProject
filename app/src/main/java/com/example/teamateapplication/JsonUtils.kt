package com.example.teamateapplication

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// Carico il JSON e lo ricostruisco in una lista di oggetti Player
fun loadPlayersFromJson(context: Context): List<Player> {
    val jsonString = context.assets.open("players.json").bufferedReader().use { it.readText() }
    val gson = Gson()
    val playerListType = object : TypeToken<List<Player>>() {}.type
    val players = gson.fromJson<List<Player>>(jsonString, playerListType)

    // verificaro il contenuto dei giocatori caricati
    Log.d("JSON", players.toString())

    return players
}
