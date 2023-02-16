package com.example.newshomework.data.models

import com.google.gson.annotations.SerializedName

data class NewsArticlesResponse(
    @SerializedName("articles") val articles: List<NewsResponse>? = null
)
