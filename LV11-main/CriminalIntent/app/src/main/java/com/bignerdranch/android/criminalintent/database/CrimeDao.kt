package com.bignerdranch.android.criminalintent.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.bignerdranch.android.criminalintent.Crime
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface CrimeDao {
    @Query("SELECT * FROM crime")
     fun getCrimes(): Flow<List<Crime>>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    suspend fun getCrime(id: UUID): Crime

    //napišite suspend funkciju kojom ćete ažurirati postojeće podatke Crime-a u bazi podataka
    @Update
    suspend fun updateCrime(crime: Crime)
}
