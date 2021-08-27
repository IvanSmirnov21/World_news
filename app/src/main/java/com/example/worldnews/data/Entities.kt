package com.example.worldnews.data

data class WorldNewsResponse(
    val data: List<Data>
) {
    data class Data (
        val author: String,
        val title: String,
        val description: String,
        val source:String,
        val image:String,
        val published_at: String,
        val url: String
            )
}


