package com.example.newshomework.data.network

import com.example.newshomework.data.models.NewsArticlesResponse
import retrofit2.Call
import retrofit2.http.*

interface NewsService {

    @Headers("x-api-key: 6e2215d6c8824752abea6defbc421007")
    @GET("everything")
    fun getNews(@Query("q") q: String): Call<NewsArticlesResponse>
}