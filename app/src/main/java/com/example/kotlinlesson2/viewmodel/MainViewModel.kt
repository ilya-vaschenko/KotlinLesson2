package com.example.kotlinlesson2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinlesson2.modl.Repository
import com.example.kotlinlesson2.modl.RepositoryImpl

class MainViewModel(private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()) :
    ViewModel() {

    private val repository: Repository = RepositoryImpl()
    val liveData: LiveData<AppState> = liveDataToObserve

    fun getFilmFromLocalSource(isRus: Boolean = true) = getDataFromLocalSource(isRus)


    private fun getDataFromLocalSource(isRus: Boolean = true) {
        liveDataToObserve.value = AppState.Loading

        Thread {
            Thread.sleep(2000)
            liveDataToObserve.postValue(AppState.Success(
                if(isRus){
                    repository.getFilmFromLocalStorageRus()
                } else {
                    repository.getFilmFromLocalStorageWorld()
                }
            ))
        }.start()
    }
}

