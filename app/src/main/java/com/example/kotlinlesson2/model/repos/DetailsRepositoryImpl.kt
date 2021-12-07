package com.example.kotlinlesson2.model.repos

import com.example.kotlinlesson2.model.RemoteDataSource
import okhttp3.Callback

class DetailsRepositoryImpl(private val remoteDataSource: RemoteDataSource) :
    DetailsRepository {
    override fun getFilmByOkHttp(requestLink: String, callback: Callback) {
        remoteDataSource.getFilmFromRemoteDataSourceByOk(requestLink, callback)
    }
}