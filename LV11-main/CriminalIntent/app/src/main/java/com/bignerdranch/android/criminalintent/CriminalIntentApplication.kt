package com.bignerdranch.android.criminalintent

import android.app.Application

class CriminalIntentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // inicijalizirati CrimeRepository, provjeriti je li CriminalIntentApplication dodan u Manifestu
        CrimeRepository.initialize(applicationContext)
    }
}
