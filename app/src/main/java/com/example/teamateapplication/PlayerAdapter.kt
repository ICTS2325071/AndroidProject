package com.example.teamateapplication

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter(
    private val context: Context,
    private var players: List<Player>,
    private val targetActivity: Class<*>,
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    // ViewHolder dove gestisco ogni elemento della lista
    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val buttonPlayer: Button = itemView.findViewById(R.id.button_player)
        val imageViewPlayer: ImageView = itemView.findViewById(R.id.player_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.player_item, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]

        // Imposto il nome e cognome nel bottone
        holder.buttonPlayer.text = player.name

        // verificaro i dati del singolo giocatore
        Log.d("PlayerAdapter", "Player: $player")

        // Assegno il listener per il click sulla TextView
        holder.buttonPlayer.setOnClickListener {
            val intent = Intent(holder.itemView.context, targetActivity)
            intent.putExtra("player_name", player.name)
            holder.itemView.context.startActivity(intent)
        }

        // Converto la stringa in un ID drawable
        val context = holder.itemView.context
        val flagDrawableId = context.resources.getIdentifier(player.flagResId, "drawable", context.packageName)
        val playerDrawableId = context.resources.getIdentifier(player.imageResId, "drawable", context.packageName)

        holder.imageViewPlayer.setImageResource(flagDrawableId)
        holder.itemView.findViewById<ImageView>(R.id.player_img).setImageResource(playerDrawableId)
    }

    override fun getItemCount(): Int = players.size

    // Metodo dove aggiorno la lista filtrata
    fun updateList(filteredPlayers: List<Player>) {
        players = filteredPlayers
        notifyDataSetChanged()
    }
}
