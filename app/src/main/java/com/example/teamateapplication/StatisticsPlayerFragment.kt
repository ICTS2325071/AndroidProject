package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class StatisticsPlayerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_statistics_player, container, false)

        val buttonInfoPlayer = view.findViewById<ImageButton>(R.id.info_player2)

        buttonInfoPlayer.setOnClickListener {
            val intent = Intent(requireContext(), PlayerInformationsActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}