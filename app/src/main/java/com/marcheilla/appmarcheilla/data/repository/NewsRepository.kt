package com.marcheilla.appmarcheilla.data.repository

import com.marcheilla.appmarcheilla.data.model.ActionState
import com.marcheilla.appmarcheilla.data.model.News
import com.marcheilla.appmarcheilla.data.remote.NewsServices
import com.marcheilla.appmarcheilla.data.remote.RetrofitApi
import retrofit2.await

class NewsRepository {
    private val newsServices: NewsServices by lazy { RetrofitApi.newsServices() }

    suspend fun listNews() : ActionState<List<News>> {
        return try {
            val list = newsServices.listNews().await()
            ActionState(list.articles)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailNews(url: String) : ActionState<News> {
        return try {
            val list = newsServices.detailNews(url).await()
            ActionState(list.articles.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchNews(query: String) : ActionState<List<News>> {
        return try {
            val list = newsServices.searchNews(query).await()
            ActionState(list.articles)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}