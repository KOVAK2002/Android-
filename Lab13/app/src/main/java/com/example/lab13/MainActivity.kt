package com.example.lab13

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var buttonSendSMS: Button
    private lateinit var editTextName: EditText
    private lateinit var editTextSurname: EditText
    private lateinit var editTextDOB: EditText
    private lateinit var editTextHobby: EditText
    private lateinit var editTextOccupation: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Postavljanje OnClickListener-a za gumb koji šalje SMS
        buttonSendSMS = findViewById(R.id.buttonSendSMS)
        editTextName = findViewById(R.id.editTextName)
        editTextSurname = findViewById(R.id.editTextSurname)
        editTextDOB = findViewById(R.id.editTextDOB)
        editTextHobby = findViewById(R.id.editTextHobby)
        editTextOccupation = findViewById(R.id.editTextOccupation)

        buttonSendSMS.setOnClickListener {
            val name = editTextName.text.toString()
            val surname = editTextSurname.text.toString()
            val dob = editTextDOB.text.toString()
            val hobby = editTextHobby.text.toString()
            val occupation = editTextOccupation.text.toString()

            val message = getString(R.string.message_template, name, surname, dob, hobby, occupation)

            // Kreiranje implicitnog intenta za slanje SMS-a
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, message)

            // Pokretanje aktivnosti chooser
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                println("Nema aplikacija za slanje SMS poruka.")
            }
        }
    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val configuration = Configuration()
        configuration.locale = locale
        baseContext.resources.updateConfiguration(configuration, baseContext.resources.displayMetrics)
        recreate()
    }

    // Primjer poziva funkcije za postavljanje jezika
    // setLocale("en") za engleski
    // setLocale("hr") za hrvatski
}
