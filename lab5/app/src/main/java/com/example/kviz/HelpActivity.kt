package com.example.kviz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HelpActivity : AppCompatActivity() {
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        backButton = findViewById(R.id.backButton)
        val correctAnswerTextView = findViewById<TextView>(R.id.correctAnswerTextView)
        val correctAnswer = intent.getStringExtra("correctAnswer")
        backButton.setOnClickListener {
            finish()  // Zatvara trenutnu aktivnost i vraća se na MainActivity
        }
        // Dohvati TextView iz layout-a


        // Postavi preneseni točan odgovor kao tekst u TextView
        correctAnswerTextView.text = "Točan odgovor: $correctAnswer"
    }



}