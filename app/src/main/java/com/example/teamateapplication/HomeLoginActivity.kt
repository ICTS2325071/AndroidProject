package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeLoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_login)

        val button_one: Button = findViewById(R.id.button_one)
        val button_apple: Button = findViewById(R.id.button_apple)
        val button_facebook: Button = findViewById(R.id.button_facebook)
        val button_google: Button = findViewById(R.id.button_google)
        val textViewRegistrati: TextView = findViewById(R.id.textViewRegistrati)


        button_one.setOnClickListener {
            val intent = Intent(this, PhoneEmailUsernameFragment::class.java)
            startActivity(intent)
        }

        button_apple.setOnClickListener {
            val intent = Intent(this, AppleFragment::class.java)
            startActivity(intent)
        }

        button_facebook.setOnClickListener {
            val intent = Intent(this, FacebookFragment::class.java)
            startActivity(intent)
        }

        button_google.setOnClickListener {
            val intent = Intent(this, GoogleFragment::class.java)
            startActivity(intent)
        }

        textViewRegistrati.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        /*supportFragmentManager.beginTransaction()
            .replace(R.id.phone_email_username, PhoneEmailUsernameFragment())
            .replace(R.id.apple, AppleFragment())
            .replace(R.id.facebook, FacebookFragment())
            .replace(R.id.google, GoogleFragment())
            .commit()*/
    }
}









