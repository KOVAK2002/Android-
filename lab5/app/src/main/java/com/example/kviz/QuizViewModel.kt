package com.example.kviz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
        var currentQuestionIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?:0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY,value)
}