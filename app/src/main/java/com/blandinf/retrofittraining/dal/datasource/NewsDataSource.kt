package com.blandinf.retrofittraining.dal.datasource

import androidx.lifecycle.LiveData
import com.blandinf.retrofittraining.models.Article

interface NewsDataSource {
    fun getArticles(query: String): LiveData<List<Article>>
}
