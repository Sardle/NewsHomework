package com.example.newshomework.di

import android.content.Context
import androidx.room.Room
import com.example.newshomework.data.database.AppDataBase
import com.example.newshomework.data.database.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    fun provideDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "database-name")
            .build()
    }

    @Provides
    fun provideUserDao(db: AppDataBase): NewsDao = db.getNewsDao()
}