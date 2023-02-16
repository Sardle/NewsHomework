package com.example.newshomework.ui

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newshomework.R
import com.example.newshomework.domain.NewsData

class NewsViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    fun onBind(item: NewsData) {
        val image = itemView.findViewById<ImageView>(R.id.image)
        val title = itemView.findViewById<TextView>(R.id.title)
        val author = itemView.findViewById<TextView>(R.id.author)

        title.text = item.title
        author.text = item.author
        getPoster(item.urlToImage, image)

        itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(item.url)
            title.context.startActivity(intent)
        }
    }

    private fun getPoster(url: String, image: ImageView) {
        Glide.with(image)
            .load(url)
            .into(image)
    }
}