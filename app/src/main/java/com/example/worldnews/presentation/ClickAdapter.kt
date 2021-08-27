package com.example.worldnews.presentation

import com.example.worldnews.data.WorldNewsResponse

interface ClickAdapter {
    fun onclick(newsCl: WorldNewsResponse.Data)
}