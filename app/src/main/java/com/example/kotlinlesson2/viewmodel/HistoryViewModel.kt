package com.example.kotlinlesson2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinlesson2.model.database.HistoryEntity

import com.example.kotlinlesson2.model.repos.LocalRepositoryImpl
import com.example.kotlinlesson2.view.App

class HistoryViewModel : ViewModel() {

    private val historyRepository = LocalRepositoryImpl(App.getHistoryDao())

    fun getAllHistory(): List<HistoryEntity> = historyRepository.getAllHistory()

}