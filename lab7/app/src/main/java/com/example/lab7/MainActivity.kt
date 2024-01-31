package com.example.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    private lateinit var imeEditText: EditText
    private lateinit var  prezimeEditText: EditText
    private lateinit var datumRodjenjaEditText: EditText
    private lateinit var muskiRadioButton: RadioButton
    private lateinit var checkboxSport: CheckBox
    private lateinit var checkBoxGlazba: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spremiButton: Button = findViewById(R.id.spremiButton)

        spremiButton.setOnClickListener {
            // Dobivanje unesenih podataka
            val ime = imeEditText.text.toString()
            val prezime = prezimeEditText.text.toString()
            val datumRodjenja = datumRodjenjaEditText.text.toString()
            val spol = if (muskiRadioButton.isChecked) "Muški" else "Ženski"

            // Dobivanje odabranih aktivnosti
            val aktivnosti = mutableListOf<String>()
            if (checkboxSport.isChecked) {
                aktivnosti.add("Sport")
            }
            if (checkBoxGlazba.isChecked) {
                aktivnosti.add("Glazba")
            }
            // Dodajte ostale aktivnosti prema potrebi

            // Stvaranje objekta Osoba
            val osoba = Osoba(ime, prezime, datumRodjenja, spol, aktivnosti)

            // Prijenos podataka na sljedeću aktivnost
            val intent = Intent(this, DrugaAktivnost::class.java)
            intent.putExtra("osoba", osoba)
            startActivity(intent)
        }

    }
}