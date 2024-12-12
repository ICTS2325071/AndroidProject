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

    private val cUsername = "teamate@gmail.com"
    private val cPassword = "Romada"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_login)

        emailView = findViewById(R.id._email)
        passwordView = findViewById(R.id.new_password)
        loginButton = findViewById(R.id.loginButton)

        setListener()
    }

    private fun setListener() {
        // Listener per il click sul bottone di login
        loginButton?.setOnClickListener {
            checkFormLogin()  // Verifica prima le credenziali quando il bottone viene premuto
        }

        // Listener per le modifiche nei campi di username e password
        emailView?.addTextChangedListener {
            checkEmptyForm() // Disabilita il bottone se uno dei campi è vuoto
        }

        passwordView?.addTextChangedListener {
            checkEmptyForm() // Disabilita il bottone se uno dei campi è vuoto
        }
    }

    // Funzione per controllare se il bottone di login deve essere abilitato
    private fun checkEmptyForm() {
        val username = emailView?.text.toString()
        val password = passwordView?.text.toString()
        loginButton?.isEnabled = !(username.isEmpty() || password.isEmpty()) // Disabilita il login se vuoto
    }

    private fun checkFormLogin() {
        val username = emailView?.text.toString()
        val password = passwordView?.text.toString()

        // Verifica se i campi sono vuoti
        if (username.isEmpty() || password.isEmpty()) {
            showError(getString(R.string.login_error_message))
        } else if (username != cUsername || password != cPassword) {
            // Verifica se username o password non corrispondono
            showError(getString(R.string.login_notmatch_error))
        } else {
            // L'utente si è loggato correttamente, quindi avvia l'activity successiva
            val intent = Intent(this, StatisticsPageActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showError(errorMessage: String) {
        Snackbar.make(
            findViewById(R.id.home_login), // Usa il layout principale come riferimento per il Snackbar
            errorMessage, // Il messaggio di errore
            Snackbar.LENGTH_LONG // Durata del messaggio
        ).show()
    }
}
