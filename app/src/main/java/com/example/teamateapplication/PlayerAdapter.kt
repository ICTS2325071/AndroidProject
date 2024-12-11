package com.example.teamateapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter(private var players: List<Player>) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    // ViewHolder per gestire ogni elemento della lista
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
        holder.buttonPlayer.text = player.name
        holder.imageViewPlayer.setImageResource(player.flagResId)
    }

    override fun getItemCount(): Int = players.size

    // Metodo per aggiornare la lista filtrata
    fun updateList(filteredPlayers: List<Player>) {
        players = filteredPlayers
        notifyDataSetChanged()
    }
}
