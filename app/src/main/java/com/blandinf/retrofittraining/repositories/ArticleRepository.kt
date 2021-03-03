package com.blandinf.retrofittraining.repositories

import androidx.lifecycle.LiveData
import com.blandinf.retrofittraining.dal.datasource.NewsDataSource
import com.blandinf.retrofittraining.dal.online.ArticleOnlineDataSource
import com.blandinf.retrofittraining.models.Article

class ArticleRepository private constructor() {
    private val dataSource: NewsDataSource = ArticleOnlineDataSource()

    // Singleton
    companion object {
        private var instance: ArticleRepository? = null
        fun getInstance(): ArticleRepository {
            if (instance == null) {
                instance = ArticleRepository()
            }
            return instance!!
        }
    }

    fun getArticles(query: String): LiveData<List<Article>> {
        return dataSource.getArticles(query)
    }
}
