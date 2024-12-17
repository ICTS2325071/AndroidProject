package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class StatisticsCareerFragment : Fragment() {

    private var selectedPlayer: Player? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_statistics_career, container, false)

        // Ricevo il giocatore selezionato
        selectedPlayer = arguments?.getParcelable("selected_player")

        val buttonHardCourt = view.findViewById<Button>(R.id.hard_court_button)

        buttonHardCourt.setOnClickListener {
            openCareerStatsActivity(
                selectedPlayer?.careerStatsHardCourt,
                R.drawable.hard,
                R.color.medium_high_blue,
                "Cemento"
            )
        }

        val buttonGrassCourt = view.findViewById<Button>(R.id.grass_court_button)

        buttonGrassCourt.setOnClickListener {
            openCareerStatsActivity(
                selectedPlayer?.careerStatsGrassCourt,
                R.drawable.grass,
                R.color.green,
                "Erba"
            )
        }

        val buttonClayCourt = view.findViewById<Button>(R.id.clay_court_button)

        buttonClayCourt.setOnClickListener {
            openCareerStatsActivity(
                selectedPlayer?.careerStatsClayCourt,
                R.drawable.clay,
                R.color.orange,
                "Terra rossa"
            )
        }

        return view
    }

    private fun openCareerStatsActivity(careerStats: CareerStats?, backgroundResId: Int, textViewColorResId: Int, textToDisplay: String) {
        selectedPlayer?.let { player ->
            val intent = Intent(requireContext(), CareerStatsActivity::class.java)
            intent.putExtra("player_name", player.name)
            intent.putExtra("player_flag", player.flagResId)
            intent.putExtra("player_image", player.imageResId)
            intent.putExtra("career_stats", careerStats)
            intent.putExtra("background_res_id", backgroundResId)
            intent.putExtra("text_view_color_res_id", textViewColorResId)
            intent.putExtra("text_to_display", textToDisplay)
            startActivity(intent)
        }
    }
}