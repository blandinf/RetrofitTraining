package com.blandinf.retrofittraining.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blandinf.retrofittraining.models.Article
import com.blandinf.retrofittraining.repositories.ArticleRepository

class HomeViewModel : ViewModel() {

    private val repository: ArticleRepository = ArticleRepository.getInstance()

    fun loadArticles(query: String): LiveData<List<Article>> {
        Log.v("articles", "LoadArticles")
        return repository.getArticles(query)
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}
