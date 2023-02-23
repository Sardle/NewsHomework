package com.example.newshomework.domain

interface Repository {

    suspend fun getNews(cache: Boolean): List<NewsData>

    fun setUserToken(token: String)
}