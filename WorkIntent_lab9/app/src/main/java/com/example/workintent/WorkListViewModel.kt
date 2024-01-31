package com.example.workintent

import androidx.lifecycle.ViewModel
import java.util.*

class WorkListViewModel : ViewModel() {

    val jobs = mutableListOf<Work>()
init {

       //stvorite 100 instanci Work klase i postavite ih
        // u jobs listu
    var number = 1
    repeat(100) {
        val work = Work(
            id = UUID.randomUUID(),
            title = "Work $number",
            date = Date(),
            isSolved = false
        )
        jobs.add(work)
        number +=1
    }

    }
}



