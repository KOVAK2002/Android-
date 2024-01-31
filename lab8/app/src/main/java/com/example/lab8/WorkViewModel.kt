package com.example.lab8

import androidx.lifecycle.ViewModel
import java.util.ArrayList

class WorkViewModel : ViewModel() {
    val workList:ArrayList<Work> = arrayListOf()
    fun addToWorkList(title:String,isSolved:Boolean){
        val work = Work(title,isSolved)
        workList.add(work)
    }
}