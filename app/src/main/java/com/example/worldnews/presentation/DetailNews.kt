package com.example.worldnews.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.worldnews.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_news.*


class DetailNews : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //titleText.text = arguments?.getString("Title")
        arguments?.getString("Title")?.let {
            titleText.text = it
        }

        arguments?.getString("Description")?.let {
            textDescription.text = it
        }

        arguments?.getString("image")?.let {
            if (it != null) {
                Picasso.get().load(it).into(imageDetail)
            }
        }

        arguments?.getString("url")?.let {
            urlContent.text = it
        }

    }
}




