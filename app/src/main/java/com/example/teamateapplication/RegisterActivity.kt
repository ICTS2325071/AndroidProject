package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val linearLayoutBack = findViewById<LinearLayout>(R.id.back)
        val linearLayoutLogin = findViewById<LinearLayout>(R.id.login)

        linearLayoutBack.setOnClickListener {
            finish()
        }

        linearLayoutLogin.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }
}