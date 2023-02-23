package com.example.newshomework.data.mappers

import com.example.newshomework.data.database.NewsEntity
import com.example.newshomework.domain.NewsData
import javax.inject.Inject

class DataBaseMapper @Inject constructor() {
    fun dataToEntity(data: List<NewsData>): List<NewsEntity> {
        return data.map {
            NewsEntity(
                author = it.author,
                title = it.title,
                description = it.description,
                url = it.url,
                urlToImage = it.urlToImage
            )
        }
    }

    fun entityToData(data: List<NewsEntity>): List<NewsData> {
        return data.map {
            NewsData(
                author = it.author,
                title = it.title,
                description = it.description,
                url = it.url,
                urlToImage = it.urlToImage
            )
        }
    }
}