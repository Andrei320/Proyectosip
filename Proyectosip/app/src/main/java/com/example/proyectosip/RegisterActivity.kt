package com.example.proyectosip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_register.*
import java.security.Provider

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //Setup
        setup()
    }

    private fun setup() {

        title = "Registro"

        AceptarButton.setOnClickListener {
            if (EmailET.text.isNotEmpty() && PasswordET.text.isNotEmpty()){

                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(EmailET.text.toString(),
                    PasswordET.text.toString()).addOnCompleteListener(){
                        if (it.isSuccessful){
                            showAuth()
                        }
                        else {
                            showAlert()
                        }
                    }
            }
        }

        CancelarButton.setOnClickListener {
            if (EmailET.text.isEmpty() && PasswordET.text.isEmpty()) {

                backAuth()
            }
            else
            {
                backAuth()
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
        onBackPressed()
    }

    private fun showAuth() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Felicidades")
        builder.setMessage("El registro se ha completado con exito")
        builder.setPositiveButton("Aceptar", null)
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun backAuth() {

        val registerIntent = Intent(this, AuthActivity::class.java)
        startActivity(registerIntent)
    }
}
