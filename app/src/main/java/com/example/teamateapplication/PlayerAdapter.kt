package com.example.teamateapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter(
    private var players: List<Player>,
    private val onItemClicked: (Player) -> Unit // Callback per il click
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

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

        // Assegna il listener per il click sulla TextView
        holder.buttonPlayer.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, PlayerInformationsActivity::class.java)
            // Passa i dati del giocatore all'altra Activity
            intent.putExtra("player_name", player.name)
            intent.putExtra("player_country", player.flagResId)
            intent.putExtra("player_image", player.imageResId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = players.size

    // Metodo per aggiornare la lista filtrata
    fun updateList(filteredPlayers: List<Player>) {
        players = filteredPlayers
        notifyDataSetChanged()
    }
}
