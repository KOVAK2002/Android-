package com.example.workintent


import java.util.Date
import java.util.UUID

data class Work(
    val id : UUID,
    val title: String,
    val date:Date,
    val isSolved : Boolean)
