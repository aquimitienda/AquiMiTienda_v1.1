package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Clientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientes)
        title = getString(R.string.title_clientes)

    }
}