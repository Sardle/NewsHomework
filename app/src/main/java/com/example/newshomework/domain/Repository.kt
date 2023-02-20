package com.example.newshomework.domain

interface Repository {

    suspend fun getNews(): List<NewsData>
}