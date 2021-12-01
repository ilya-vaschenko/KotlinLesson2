package com.example.kotlinlesson2.model.repos

import androidx.room.Entity
import com.example.kotlinlesson2.model.database.HistoryEntity


interface LocalRepository { //класс, который будет отвечать за работу с локальными данными
    fun getAllHistory(): List<HistoryEntity>
    fun saveEntity(film: HistoryEntity)
}