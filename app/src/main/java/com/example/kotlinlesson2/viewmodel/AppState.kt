package com.example.kotlinlesson2.viewmodel

import com.example.kotlinlesson2.modl.Film

sealed class AppState {
    data class Success(val filmsList: List<Film>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}