package com.bignerdranch.android.criminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bignerdranch.android.criminalintent.Crime

@Database(entities = [Crime::class], version = 1)
// Omogućiti bazi podataka pretvaranje ne-primitivnih tipova podataka iz klase CrimeTypeConverters
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDatabase : RoomDatabase() {
    // dodati deklaraciju abstraktne funkcije crimeDao
    abstract fun crimeDao(): CrimeDao
}
