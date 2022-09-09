package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(3000)
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screenSplash.setKeepOnScreenCondition {false}
        setup()
        title = getString(R.string.title_login)

    }

    private fun setup(){

        singUpButton.setOnClickListener {
            if (emailEditText.text.isNotEmpty() && PasswordEditText.text.isNotEmpty()){

                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(emailEditText.text.toString(),
                    PasswordEditText.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Registro Satisfactorio", Toast.LENGTH_SHORT).show()
                       val clientes= Intent(this,Clientes::class.java)
                        startActivity(clientes)
                    } else{

                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("Error")
                        builder.setMessage("Se ha producido un error de autenticacion al usuario")
                        builder.setPositiveButton("Aceptar",null)
                        val dialog: AlertDialog = builder.create()
                        dialog.show()


                    }


                }


            }

        }


        loginButton.setOnClickListener {
            if (emailEditText.text.isNotEmpty() && PasswordEditText.text.isNotEmpty()){

                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(emailEditText.text.toString(),
                    PasswordEditText.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        val clientes= Intent(this,Clientes::class.java)
                        startActivity(clientes)
                    } else{

                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("Error")
                        builder.setMessage("Se ha producido un error de autenticacion al usuario")
                        builder.setPositiveButton("Aceptar",null)
                        val dialog: AlertDialog = builder.create()
                        dialog.show()


                    }


                }


            }

        }




    }












}