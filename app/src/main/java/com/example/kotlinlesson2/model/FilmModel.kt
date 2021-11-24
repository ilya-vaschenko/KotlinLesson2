package com.example.kotlinlesson2.model

import com.google.gson.annotations.SerializedName

data class FilmModel(

    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val result: List<FilmDTO>,
)
