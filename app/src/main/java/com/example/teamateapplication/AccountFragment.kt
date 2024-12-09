package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_account, container, false)

        val buttonHome = view.findViewById<ImageButton>(R.id.imageButton_home)
        val buttonStar = view.findViewById<ImageButton>(R.id.imageButton_favourites)
        val buttonSettings = view.findViewById<ImageButton>(R.id.imageButton_settings)

        buttonHome.setOnClickListener {
            val intent = Intent(requireContext(), HomePageActivity::class.java)
            startActivity(intent)
        }

        buttonStar.setOnClickListener {
            val intent = Intent(requireContext(), PreferitiActivity::class.java)
            startActivity(intent)
        }

        buttonSettings.setOnClickListener {
            val intent = Intent(requireContext(), ImpostazioniActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}