package com.example.worldnews.data

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.file.attribute.AclEntry

class WorldNewsRepository {
    private val coroutineContext = Dispatchers.IO
    private val openWorldNewsMapApi = Retrofit.Builder().baseUrl("http://api.mediastack.com/")
        .addConverterFactory(GsonConverterFactory.create()).build().create(WorldNewsMap::class.java)


    suspend fun getWorldNewsResult (categories: String, date:String) = withContext(coroutineContext) {
        openWorldNewsMapApi.getWorldNews(categories,languages = "en",date).execute().body()
    }
}