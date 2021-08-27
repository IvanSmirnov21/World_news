package com.example.worldnews.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.worldnews.R
import com.example.worldnews.data.WorldNewsRepository
import com.example.worldnews.data.WorldNewsResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_detail_news.*
import kotlinx.android.synthetic.main.item_view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.*
import java.util.zip.Inflater

class MainActivity : Fragment(),CoroutineScope {
    override val coroutineContext = Dispatchers.Main
    private val repository = WorldNewsRepository()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_main, container, false)





//        navView.setNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.itemGeneral -> {
//                    val data = editText.text.toString()
//
//                    launch {
//                        val response = repository.getWorldNewsResult("general", data)
//                        response?.apply { }
//                    }
//
//                }
//            }
//            true
//        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = AdapterRW(object : ClickAdapter{
            override fun onclick(newsCl: WorldNewsResponse.Data) {
                val fragment = DetailNews()
                val titleDetail = text_title.text.toString()
                val textDetail = newsCl.description
                val imageTitle = newsCl.image
                val url = newsCl.url
                fragment.arguments = Bundle().also {
                    it.putString("Title",titleDetail)
                    it.putString("Description",textDetail)
                    it.putString("image",imageTitle)
                    it.putString("url",url)

                }
                parentFragmentManager.beginTransaction().replace(R.id.fragment_host,fragment).addToBackStack(null).commit()



            }
        })

        recycler_view.adapter = adapter

            buttonData.setOnClickListener {
            launch {
                val data2 = editText.text.toString()
                val response = repository.getWorldNewsResult("general", data2)
                response?.apply {
                    adapter.updateNews(data)
                }


                } }

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemGeneral -> {

                        launch {
                            val data2 = editText.text.toString()
                            val data3 = DateFormat.getDateInstance(Calendar.DAY_OF_WEEK_IN_MONTH)
                            val response = repository.getWorldNewsResult("general", data2)
                            response?.apply {
                                adapter.updateNews(data)
                            }


                        }

               }
                R.id.itemBusiness -> {

                        launch {
                            val data2 = editText.text.toString()
                            val response = repository.getWorldNewsResult("business", data2)
                            response?.apply {
                                adapter.updateNews(data)
                            }


                        }
                }
            }

            true
     }


    }

            }

