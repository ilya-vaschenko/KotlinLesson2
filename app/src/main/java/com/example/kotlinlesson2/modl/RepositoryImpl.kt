package com.example.kotlinlesson2.modl

import com.example.kotlinlesson2.R

class RepositoryImpl : Repository {
    override fun getFilmFromServer(): Film = Film()

    override fun getFilmFromLocalStorageRus(): List<Film> = getRusFilms()

    override fun getFilmFromLocalStorageWorld(): List<Film> = getWorldFilms()


}