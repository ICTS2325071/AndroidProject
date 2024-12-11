package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StatisticsPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics_page)

        val buttonSinner: Button = findViewById(R.id.button_sinner)
        val buttonZverev: Button = findViewById(R.id.button_zverev)
        val buttonAlcaraz:  Button = findViewById(R.id.button_alcaraz)
        val buttonFritz: Button = findViewById(R.id.button_fritz)
        val buttonMedvedev: Button = findViewById(R.id.button_medvedv)



        val buttonHome = findViewById<ImageButton>(R.id.imageButton_home)
        val buttonStar = findViewById<ImageButton>(R.id.imageButton_favourites)
        val buttonSettings = findViewById<ImageButton>(R.id.imageButton_settings)

        buttonHome.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }

        buttonStar.setOnClickListener {
            val intent = Intent(this, PreferitiActivity::class.java)
            startActivity(intent)
        }

        buttonSettings.setOnClickListener {
            val intent = Intent(this, ImpostazioniActivity::class.java)
            startActivity(intent)
        }

        buttonSinner.setOnClickListener {
            val intent = Intent(this, PlayerInformationsActivity::class.java)
            startActivity(intent)
        }

        buttonZverev.setOnClickListener {
            val intent = Intent(this, PlayerInformationsActivity::class.java)
                startActivity(intent)
            }

        buttonAlcaraz.setOnClickListener {
            val intent = Intent(this, PlayerInformationsActivity::class.java)
                    startActivity(intent)
                }

        buttonFritz.setOnClickListener {
            val intent = Intent(this, PlayerInformationsActivity::class.java)
                        startActivity(intent)
                    }

        buttonMedvedev.setOnClickListener {
            val intent = Intent(this, PlayerInformationsActivity::class.java)
                            startActivity(intent)
                        }

        }

                 }
