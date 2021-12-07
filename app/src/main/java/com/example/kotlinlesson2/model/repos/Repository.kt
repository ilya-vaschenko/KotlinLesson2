package com.example.kotlinlesson2.model.repos

import com.example.kotlinlesson2.model.Film
import com.example.kotlinlesson2.model.FilmModel

interface Repository {
    fun getFilmFromServer(): Film
//    fun getFilmFromLocalStorageRus(): List<Film>
//    fun getFilmFromLocalStorageWorld(): List<Film>

    fun getPopularFilmsByRetro(callback: retrofit2.Callback<FilmModel>)

}