package com.example.worldnews.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.worldnews.R

class Main: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_host,MainActivity()).commit()
    }
    }
