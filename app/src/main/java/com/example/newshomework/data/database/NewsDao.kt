package com.example.newshomework.data.database

import androidx.room.*

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getAll(): List<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<NewsEntity>)

    @Delete
    fun delete(users: List<NewsEntity>)
}