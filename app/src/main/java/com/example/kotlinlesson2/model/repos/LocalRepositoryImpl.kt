package com.example.kotlinlesson2.model.repos

import androidx.room.Entity
import com.example.kotlinlesson2.model.database.HistoryDao
import com.example.kotlinlesson2.model.database.HistoryEntity

class LocalRepositoryImpl(private val dao: HistoryDao) : LocalRepository {

    override fun getAllHistory(): List<HistoryEntity> = dao.all()

    override fun saveEntity(film: HistoryEntity) {
        dao.insert(film)
    }
}