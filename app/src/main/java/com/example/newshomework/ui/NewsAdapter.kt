package com.example.newshomework.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newshomework.R
import com.example.newshomework.domain.NewsData

class NewsAdapter() : RecyclerView.Adapter<NewsViewHolder>() {

    private val listCatData = mutableListOf<NewsData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.onBind(listCatData[position])
    }

    override fun getItemCount(): Int = listCatData.size

    fun setItems(items: List<NewsData>) {
        listCatData.clear()
        listCatData.addAll(items)
        notifyDataSetChanged()
    }
}