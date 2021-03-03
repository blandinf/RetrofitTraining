package com.blandinf.retrofittraining.dal.utils

import com.blandinf.retrofittraining.dal.online.models.ItemResponse
import com.blandinf.retrofittraining.dal.online.models.SourceResponse
import com.blandinf.retrofittraining.models.Article
import com.blandinf.retrofittraining.models.Source

fun ItemResponse.toArticle() = Article(
    author = author ?: "",
    content = content ?: "",
    title = title ?: "",
    description = description ?: "",
    publishedAt = publishedAt ?: "",
    source = source?.toSource(),
    url = url ?: "",
    urlToImage = urlToImage ?: ""
)

fun SourceResponse.toSource() = Source(
    id = id ?: "",
    name = name ?: ""
)
