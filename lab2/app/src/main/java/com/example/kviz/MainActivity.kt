package com.example.kviz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private var currentQuestion = 1

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.questionTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)

        trueButton.setOnClickListener {
            checkAnswer(getString(R.string.correct_answer))
        }

        falseButton.setOnClickListener {
            checkAnswer(getString(R.string.incorrect_answer))
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        when (currentQuestion) {
            1 -> questionTextView.text = getString(R.string.question1)
            2 -> questionTextView.text = getString(R.string.question2)
            3 -> questionTextView.text = getString(R.string.question3)
            4 -> questionTextView.text = getString(R.string.question4)
            5 -> questionTextView.text = getString(R.string.question5)
        }
    }

    private fun checkAnswer(userAnswer: String) {
        val correctAnswer: String = when (currentQuestion) {
            1 -> getString(R.string.correct_answer)
            2 -> getString(R.string.incorrect_answer)
            3 -> getString(R.string.correct_answer)
            4 -> getString(R.string.incorrect_answer)
            5 -> getString(R.string.correct_answer)

            // Dodajte odgovarajuće odgovore za ostala pitanja
            else -> ""
        }

        if (userAnswer == correctAnswer) {
            showToastMessage("Točno")
        } else {
            showToastMessage("Netočno")
        }

        if (currentQuestion < 5) {
            currentQuestion++
            updateQuestion()
        } else {
            showToastMessage("Kviz je završen!")
        }
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}