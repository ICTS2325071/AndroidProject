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

        val buttonOne: Button = findViewById(R.id.button_one)
        val buttonApple: Button = findViewById(R.id.button_apple)
        val buttonFacebook: Button = findViewById(R.id.button_facebook)
        val buttonGoogle: Button = findViewById(R.id.button_google)
        val textViewRegistered: TextView = findViewById(R.id.textView_registered)


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

        textViewRegistered.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}

        /*buttonApple.setOnClickListener {
            val bottom2 = AppleFragment()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, bottom2)
                .commit()

            findViewById<FrameLayout>(R.id.fragment_container).visibility = View.VISIBLE
        }
    }
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


            .replace(R.id.apple, AppleFragment())
            .replace(R.id.facebook, FacebookFragment())
            .replace(R.id.google, GoogleFragment())*/









