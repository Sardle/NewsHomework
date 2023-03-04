package com.example.newshomework.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NewsEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao
}