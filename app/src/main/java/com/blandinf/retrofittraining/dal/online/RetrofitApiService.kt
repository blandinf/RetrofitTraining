package com.blandinf.retrofittraining.dal.online

import com.blandinf.retrofittraining.dal.online.models.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService {
    @GET("everything")
    fun getArticlesResponse(@Query("q") query: String): Call<ArticleResponse>
}
