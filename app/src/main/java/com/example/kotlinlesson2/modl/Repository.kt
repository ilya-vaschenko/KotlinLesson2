package com.example.kotlinlesson2.modl

interface Repository {
    fun getFilmFromServer(): Film
    fun getFilmFromLocalStorage(): List<Film>

}