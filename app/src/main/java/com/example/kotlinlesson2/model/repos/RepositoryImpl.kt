package com.example.kotlinlesson2.model.repos

import com.example.kotlinlesson2.model.*
import retrofit2.Callback

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository {
    override fun getFilmFromServer(): Film = Film()

    override fun getFilmFromLocalStorageRus(): List<Film> = getRusFilms()

    override fun getFilmFromLocalStorageWorld(): List<Film> = getWorldFilms()

    override fun getPopularFilmsByRetro(callback: Callback<FilmModel>) {
        remoteDataSource.getPopularFilmsFromRemoteDataSource(callback)
    }
}