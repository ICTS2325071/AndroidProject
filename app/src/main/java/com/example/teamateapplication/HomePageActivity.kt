package com.example.teamateapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class  HomePageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val  CustomButtonStatistics = findViewById<Button>(R.id.button_statistics)
        CustomButtonStatistics.setOnClickListener {
            loadActivity(StatisticsPageActivity())
        }
    }
}