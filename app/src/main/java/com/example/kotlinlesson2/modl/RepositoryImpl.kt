package com.example.kotlinlesson2.modl

import com.example.kotlinlesson2.R

class RepositoryImpl : Repository {
    override fun getFilmFromServer(): Film = Film()

    override fun getFilmFromLocalStorage(): List<Film> {
        return listOf(
            Film(imageIndex = R.drawable.zayc),
            Film("Сова", "мьюзикл", 1950, R.drawable.sova),
            Film("Ворон", "история", 2021,  R.drawable.voron),
            Film("Хрюша", "документальный", 1991,  R.drawable.hrusha),
        )
    }

}