package com.example.kotlinlesson2.model.retrofit

import com.example.kotlinlesson2.model.FilmDTO
import com.example.kotlinlesson2.model.FilmModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmApi {
    @GET("/3/discover/movie?sort_by=popularity.desc")
    fun getPopularFilm(
        @Query("api_key") apiKey: String,
        @Query("language") lanq: String
    ): Call<FilmModel>

    @GET("movie/{id}")
    fun getFilm(
        @Path("id") id: Long,
        @Query("api_key") apiKey: String
    ): Call<FilmDTO>

}