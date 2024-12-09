package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class HomeLoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_login)

        val textViewRegistered = findViewById<TextView>(R.id.textView_registered)
        val buttonOne: Button = findViewById(R.id.button_one)
        val buttonApple: Button = findViewById(R.id.button_apple)
        val buttonFacebook: Button = findViewById(R.id.button_facebook)
        val buttonGoogle: Button = findViewById(R.id.button_google)

        textViewRegistered.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        buttonOne.setOnClickListener {
            loadFragment(PhoneEmailUsernameFragment())
        }

        buttonApple.setOnClickListener {
            loadFragment(AppleFragment())
        }

        buttonFacebook.setOnClickListener {
            loadFragment(FacebookFragment())
        }

        buttonGoogle.setOnClickListener {
            loadFragment(GoogleFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
