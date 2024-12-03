package com.example.teamateapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ImpostazioniActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_impostazioni)

        supportFragmentManager.beginTransaction()
            .replace(R.id.account, AccountFragment())
            .commit()
    }
}