package com.blandinf.retrofittraining.dal.online.models

data class ArticleResponse(
    val articles: List<ItemResponse>,
    val status: String?,
    val totalResults: Int?
)

data class ItemResponse(
    val source: SourceResponse,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

data class SourceResponse(
    val id: String,
    val name: String
)
