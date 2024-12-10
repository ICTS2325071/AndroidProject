package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout

class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_account, container, false)

        val buttonChangeUsername = view.findViewById<Button>(R.id.button_change_user)
        val buttonChangeEmail = view.findViewById<Button>(R.id.button_change_email)
        val buttonChangePassword = view.findViewById<Button>(R.id.button_change_psw)

        val buttonHome = view.findViewById<ImageButton>(R.id.imageButton_home)
        val buttonStar = view.findViewById<ImageButton>(R.id.imageButton_favourites)
        val buttonSettings = view.findViewById<ImageButton>(R.id.imageButton_settings)

        buttonChangeUsername.setOnClickListener {
            val intent = Intent(requireContext(), UsernameActivity::class.java)
            startActivity(intent)
        }

        buttonChangeEmail.setOnClickListener {
            val intent = Intent(requireContext(), EmailActivity::class.java)
            startActivity(intent)
        }

        buttonChangePassword.setOnClickListener {
            val intent = Intent(requireContext(), PasswordActivity::class.java)
            startActivity(intent)
        }


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