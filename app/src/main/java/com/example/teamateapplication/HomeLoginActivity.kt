package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar

class HomeLoginActivity : AppCompatActivity() {

    private var emailView: EditText? = null
    private var passwordView: EditText? = null
    private var loginButton: Button? = null

    private val cEmail = "teamate@gmail.com"
    private val cPassword = "Romada"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_login)

        emailView = findViewById(R.id.editText_email)
        passwordView = findViewById(R.id.editText_password)
        loginButton = findViewById(R.id.login_button)

        setListeners()
    }

    private fun setListeners() {
        // Listener per il click sul bottone di login
        loginButton?.setOnClickListener {
            checkFormLogin() // Verifica le credenziali
        }

        // Listener per abilitare/disabilitare il pulsante di login quando i campi cambiano
        emailView?.addTextChangedListener {
            checkEmptyForm()
        }

        passwordView?.addTextChangedListener {
            checkEmptyForm()
        }
    }

    private fun checkEmptyForm() {
        val email = emailView?.text.toString()
        val password = passwordView?.text.toString()

        // Abilita il pulsante solo se entrambi i campi non sono vuoti
        loginButton?.isEnabled = !(email.isEmpty() || password.isEmpty())
    }

    private fun checkFormLogin() {
        val email = emailView?.text.toString()
        val password = passwordView?.text.toString()

        if (email != cEmail || password != cPassword) {
            showError(getString(R.string.login_notmatch_error))
        } else {
            // Login corretto, avvia l'activity successiva
            val intent = Intent(this, StatisticsPageActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showError(errorMessage: String) {
        // Mostra un messaggio di errore usando uno Snackbar
        val rootView = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.home_login)
        Snackbar.make(
            rootView,
            errorMessage,
            Snackbar.LENGTH_LONG
        ).show()
    }
}
