// DrugaAktivnost.kt
package com.example.lab7

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DrugaAktivnost : AppCompatActivity() {
    private lateinit var prikazTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_druga_aktivnost)

        // Dobivanje podataka o osobi iz Intenta
        val osoba = intent.getSerializableExtra("osoba") as? Osoba

        // Prikazivanje podataka
        osoba?.let {
            val prikazTeksta = "Ime: ${it.ime}\nPrezime: ${it.prezime}\nDatum rođenja: ${it.datumRodjenja}\nSpol: ${it.spol}\nAktivnosti: ${it.aktivnosti.joinToString(", ")}"
            prikazTextView.text = prikazTeksta
        }
    }
}
