package com.example.kotlinlesson2.model

interface Repository {
    fun getFilmFromServer(): Film
    fun getFilmFromLocalStorageRus(): List<Film>
    fun getFilmFromLocalStorageWorld(): List<Film>

}