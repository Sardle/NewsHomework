package com.example.newshomework.data.source

import com.example.newshomework.data.database.NewsDao
import com.example.newshomework.data.database.NewsEntity
import javax.inject.Inject

class DataBaseSource @Inject constructor(
    private val dao: NewsDao
) {


    fun getAll(): List<NewsEntity> = dao.getAll()

    fun insertAll(users: List<NewsEntity>) = dao.insertAll(users)

    fun delete(users: List<NewsEntity>) = dao.delete(users)
}