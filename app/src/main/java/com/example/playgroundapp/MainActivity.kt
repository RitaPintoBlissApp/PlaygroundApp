package com.example.playgroundapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Código para iniciar a atividade "Landing"
        val intent = Intent(this, LandingActivity::class.java)
        startActivity(intent)
    }
}