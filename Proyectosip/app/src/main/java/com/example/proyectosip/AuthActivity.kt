package com.example.proyectosip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //Analytics Event
        val analytics : FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integracion de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        //Setup
        setup()
    }

    private fun setup()
    {

        title = "Autenticacion"


        loginButton.setOnClickListener {
            if (EmailLET.text.isNotEmpty() && PasswordLET.text.isNotEmpty()) {

            }
            else
            {
                showAlert()
            }
        }


        signUpButton.setOnClickListener {
            if (EmailLET.text.isEmpty() && PasswordLET.text.isEmpty()) {
                        showRegister()
            }
            else
            {
                showRegister()
            }
        }
    }

    private fun showAlert() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autenticar al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun showRegister() {

        val registerIntent = Intent(this, RegisterActivity::class.java)
        startActivity(registerIntent)
    }

}