package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class AppleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_apple, container, false)

        val linearLayoutLogin = view.findViewById<LinearLayout>(R.id.login)
        val linearLayoutBack = view.findViewById<LinearLayout>(R.id.back)

        linearLayoutBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        linearLayoutLogin.setOnClickListener {
            val intent = Intent(requireContext(), HomePageActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}