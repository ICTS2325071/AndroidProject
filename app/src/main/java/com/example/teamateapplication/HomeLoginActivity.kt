package com.example.teamateapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar

class HomeLoginActivity : AppCompatActivity() {

    private lateinit var emailView: EditText
    private lateinit var passwordView: EditText
    private lateinit var loginButton: Button

    private val cEmail = "teamate@gmail.com"
    private val cPassword = "Romada"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_login)

        // Collegamento degli elementi UI ai loro ID
        emailView = findViewById(R.id._email)
        passwordView = findViewById(R.id.new_password)
        loginButton = findViewById(R.id.loginButton)

        // Imposta i listener
        setListeners()
    }

    private fun setListeners() {
        // Listener per il click sul bottone di login
        loginButton.setOnClickListener {
            checkFormLogin() // Verifica le credenziali
        }

        // Listener per abilitare/disabilitare il pulsante di login quando i campi cambiano
        emailView.addTextChangedListener {
            checkEmptyForm()
        }

        passwordView.addTextChangedListener {
            checkEmptyForm()
        }
    }

    private fun checkEmptyForm() {
        val email = emailView.text.toString().trim()
        val password = passwordView.text.toString().trim()

        // Abilita il pulsante solo se entrambi i campi non sono vuoti
        loginButton.isEnabled = email.isNotEmpty() && password.isNotEmpty()
    }

    private fun checkFormLogin() {
        val email = emailView.text.toString().trim()
        val password = passwordView.text.toString().trim()

        // Log per il debug
        println("Email inserita: $email, Password inserita: $password")

        when {
            email.isEmpty() || password.isEmpty() -> {
                showError(getString(R.string.login_error_message))
            }
            email != cEmail || password != cPassword -> { // Usa cEmail
                showError(getString(R.string.login_notmatch_error))
            }
            else -> {
                // Login corretto, avvia l'activity successiva
                val intent = Intent(this, StatisticsPageActivity::class.java)
                startActivity(intent)
            }
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
