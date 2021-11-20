package com.example.kotlinlesson2.model

data class FilmDTO(
    val genres: List<GenresDTO?>,
    val title: String?,
    val id: Long?,
    val release_date: String?,
    val overview: String?,
    val poster_path: String?,
) {
    data class GenresDTO(
        val id: Long?,
        val name: String?
    )
}