package com.example.kotlinlesson2.model

import android.os.Parcelable
import com.example.kotlinlesson2.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    var id: Long = 550,
    var name: String = "Заяц",
    var genre: String = "Ужасы",
    var date: String = "2020",
    var imageIndex: Int = 0,
    var description: String = "Нет описания",
    val posterPath: String? = ""
) : Parcelable

fun getWorldFilms(): List<Film> = listOf(
    Film(566525, "Шан-Чи и легенда десяти колец", "приключения", "2021", R.drawable.zayc2),
    Film(580489, "Веном 2", "приключения", "2021", R.drawable.zayc2),
    Film(522402, "Финч", "приключения", "2021", R.drawable.zayc2),
)

fun getRusFilms(): List<Film> = listOf(
    Film(id = 3040, "Ночной дозор", "fantasy", "2004", R.drawable.zayc2),
    Film(id = 31418, "Все умрут, а я останусь", "drama", "2008", R.drawable.zayc2),
    Film(id = 19875, "Похороните меня за плинтусом", "drama", "2009", R.drawable.zayc2)
)

