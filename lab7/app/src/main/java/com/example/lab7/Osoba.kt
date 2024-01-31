package com.example.lab7
import java.io.Serializable
data class Osoba(
    var ime: String,
    var prezime: String,
    var datumRodjenja: String,
    var spol: String,
    var aktivnosti: List<String>
) : Serializable

