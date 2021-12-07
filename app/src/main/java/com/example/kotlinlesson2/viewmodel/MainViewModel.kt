package com.example.kotlinlesson2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinlesson2.model.Film
import com.example.kotlinlesson2.model.FilmDTO
import com.example.kotlinlesson2.model.FilmModel
import com.example.kotlinlesson2.model.RemoteDataSource
import com.example.kotlinlesson2.model.repos.Repository
import com.example.kotlinlesson2.model.repos.RepositoryImpl
import retrofit2.Call
import retrofit2.Response

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

) :
    ViewModel() {

    private val repository: Repository = RepositoryImpl(RemoteDataSource())

    val liveData: LiveData<AppState> = liveDataToObserve

    fun getFilmFromRemoteDataSource() {
        liveDataToObserve.value = AppState.Loading

        repository.getPopularFilmsByRetro(object : retrofit2.Callback<FilmModel> {

            override fun onFailure(call: Call<FilmModel>, t: Throwable) {
                Log.d("fff", t.toString())
                liveDataToObserve.postValue(AppState.Error(t))
            }

            override fun onResponse(call: Call<FilmModel>, response: Response<FilmModel>) {
                response.body()?.let {
                    liveDataToObserve.postValue(checkResponse(it.result))
                }
            }
        })
    }

    private fun checkResponse(filmDTO: List<FilmDTO>): AppState {
        val filmsList = mutableListOf<Film>()
        filmDTO.forEach {
            filmsList.add(
                Film(
                    name = it.title ?: "",
                    id = it.id ?: 0,
                    date = it.release_date ?: "",
                    genre = "fdsf",
                    description = it.overview ?: "",
                    posterPath = it.poster_path ?: ""
                )
            )
        }

        return AppState.Success(filmsList)

    }
}


