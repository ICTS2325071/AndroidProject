package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView

class StatisticsPlayerFragment : Fragment() {

    private var playerStats: PlayerStats? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            playerStats = it.getParcelable("player_stats")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_statistics_player, container, false)

        // Popola le viste con i dati di playerStats
        playerStats?.let {
            view.findViewById<TextView>(R.id.textViewRanking).text = "Ranking: ${it.ranking}"
            view.findViewById<TextView>(R.id.textViewPoints).text = "Punti: ${it.points}"
            view.findViewById<TextView>(R.id.textViewMatchesWon).text = "Partite vinte: ${it.matchesWon}"
            view.findViewById<TextView>(R.id.textViewMatchesLost).text = "Partite perse: ${it.matchesLost}"
            view.findViewById<TextView>(R.id.textViewWinRate).text = "Percentuale di vittorie: ${it.winRate}%"
            view.findViewById<TextView>(R.id.textViewTournamentsWon).text = "Tornei vinti: ${it.tournamentsWon}"
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(playerStats: PlayerStats) =
            StatisticsPlayerFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("player_stats", playerStats)
                }
            }
    }
}