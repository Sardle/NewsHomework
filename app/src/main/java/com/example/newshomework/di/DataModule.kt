package com.example.newshomework.di

import com.example.newshomework.data.RepositoryImpl
import com.example.newshomework.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun getCat(impl: RepositoryImpl): Repository
}