package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewSubtitle: TextView = findViewById(R.id.textView_subtitle)

        textViewSubtitle.setOnClickListener {
            val intent = Intent(this, HomeLoginActivity::class.java)
            startActivity(intent)
        }
    }
}