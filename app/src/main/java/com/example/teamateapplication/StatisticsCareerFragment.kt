package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout

class StatisticsCareerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_statistics_career, container, false)

        val buttonHardCourt = view.findViewById<Button>(R.id.hard_court_button)

        buttonHardCourt.setOnClickListener {
            val intent = Intent(requireContext(), HardCourtActivity::class.java)
            startActivity(intent)
        }

        val buttonGrassCourt = view.findViewById<Button>(R.id.grass_court_button)

        buttonGrassCourt.setOnClickListener {
            val intent = Intent(requireContext(), GrassCourtActivity::class.java)
            startActivity(intent)
        }

        val buttonClayCourt = view.findViewById<Button>(R.id.clay_court_button)

        buttonClayCourt.setOnClickListener {
            val intent = Intent(requireContext(), ClayCourtActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}