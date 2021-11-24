package com.example.kotlinlesson2.model.repos

import okhttp3.Callback

interface DetailsRepository {
    fun getFilmByOkHttp(request: String, callback: Callback)

}