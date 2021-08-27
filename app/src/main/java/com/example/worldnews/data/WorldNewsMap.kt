package com.example.worldnews.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WorldNewsMap {
    @GET("v1/news?access_key=bd4283b41b8a308121eb8348136e3fca")
    fun getWorldNews(
        @Query ("categories") categories: String,
        @Query("languages") languages:String = "en",
        @Query ("date") date: String
    ): Call<WorldNewsResponse>
}