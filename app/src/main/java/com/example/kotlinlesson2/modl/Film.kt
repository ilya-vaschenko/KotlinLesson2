package com.example.kotlinlesson2.modl

import android.os.Parcelable
import com.example.kotlinlesson2.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    var name: String = "Заяц",
    var genre: String = "Ужасы",
    var date: Int = 2020,
    var imageIndex: Int = 0,
    var description: String = "Нет описания"
) : Parcelable

fun getRusFilms(): List<Film> = listOf(
    Film(imageIndex = R.drawable.zayc),
    Film(
        "Сова", "мьюзикл", 1950, R.drawable.sova, "Жила – была в " +
                "Большом Лесу Маленькая Совушка. Всем она была замечательная: и хорошенькая, " +
                "и умненькая, и веселая,и на все лапки мастерица. Но вот только очень невоспитанная..."
    ),
    Film(
        "Ворон", "история", 2021, R.drawable.voron, "Жила на свете ворона. " +
                "Самая обыкновенная. И звали её Нюрка. Жила она в деревне, которая называлась Нижние Неряхи. " +
                "Ворона как ворона, только любопытна была очень, прямо как сова."
    ),
    Film(
        "Хрюша", "документальный", 1991, R.drawable.hrusha, "Хрюша – " +
                "непослушный и своенравный поросёнок, который, однако, обожает читать сказки и путешествовать."
    ),
)

fun getWorldFilms(): List<Film> = listOf(
    Film("zayac", "Horrors", 2021, R.drawable.zayc2),
    Film("Sova", "History", 2021, R.drawable.sova2),
    Film("Voron", "Documentary", 1991, R.drawable.voron2),
    Film("Hrusha", "Documentary", 1991, R.drawable.hrusha2),
)

