package com.example.newshomework.data

import com.example.newshomework.data.mappers.NewsMapper
import com.example.newshomework.data.network.NewsService
import com.example.newshomework.domain.NewsData
import com.example.newshomework.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: NewsService,
    private val mapper: NewsMapper
) : Repository {

    override suspend fun getNews(): List<NewsData> {
        return withContext(Dispatchers.IO) {
            service.getNews("bitcoin")
                .execute()
                .body()?.let { mapper(it) } ?: throw Exception()
        }
    }
}