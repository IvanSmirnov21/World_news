package com.example.worldnews.presentation

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.worldnews.R
import com.example.worldnews.data.WorldNewsResponse
import com.squareup.picasso.Picasso
import java.net.URI

class AdapterRW(private val click: ClickAdapter) : RecyclerView.Adapter<AdapterRW.ViewHolder>() {

    private var worldNews = listOf<WorldNewsResponse.Data>()


    fun updateNews(worldNews: List<WorldNewsResponse.Data>) {
        this.worldNews = worldNews
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRW.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterRW.ViewHolder, position: Int) {
        val worldNews = worldNews[position]
        holder.card.setOnClickListener {
            click.onclick(worldNews)
        }
        if (worldNews.image != null) {
            Picasso.get().load(worldNews.image).into(holder.imageView)
        }
        holder.title.text = worldNews.title
        holder.source.text = worldNews.source
        holder.data.text = worldNews.published_at.substring(0, 10)
    }

    override fun getItemCount() = worldNews.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val card: CardView = itemView.findViewById(R.id.cardView)

        val title: TextView = itemView.findViewById(R.id.text_title)
        val imageView: ImageView = itemView.findViewById(R.id.image2)
        val source: TextView = itemView.findViewById(R.id.edition)
        val data: TextView = itemView.findViewById(R.id.data_news)
    }

}