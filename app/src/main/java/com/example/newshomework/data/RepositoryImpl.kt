package com.example.newshomework.data

import com.example.newshomework.data.mappers.DataBaseMapper
import com.example.newshomework.data.mappers.NewsMapper
import com.example.newshomework.data.network.NewsService
import com.example.newshomework.data.source.DataBaseSource
import com.example.newshomework.data.source.UserDataSource
import com.example.newshomework.domain.NewsData
import com.example.newshomework.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: NewsService,
    private val mapper: NewsMapper,
    private val dbMapper: DataBaseMapper,
    private val prefs: UserDataSource,
    private val db: DataBaseSource
) : Repository {

    override suspend fun getNews(cache: Boolean): List<NewsData> {
        return withContext(Dispatchers.IO) {
            if (cache) {
                val news = service.getNews("pc technologies", prefs.getUserToken())
                    .execute()
                    .body()?.let { mapper(it) } ?: throw Exception()
                if (news.isNotEmpty()) {
                    db.delete(db.getAll())
                }
                db.insertAll(dbMapper.dataToEntity(news))
                news
            } else {
                dbMapper.entityToData(db.getAll())
            }
        }
    }

    override fun setUserToken(token: String) {
        prefs.setUserToken(token)
    }
}