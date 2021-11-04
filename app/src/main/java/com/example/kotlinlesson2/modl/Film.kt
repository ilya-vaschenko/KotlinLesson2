package com.example.kotlinlesson2.modl

data class Film(
    var name: String = "Заяц",
    var genre: String = "Ужасы",
    var date: Int = 2020,
    var imageIndex: Int = 0
) {
}