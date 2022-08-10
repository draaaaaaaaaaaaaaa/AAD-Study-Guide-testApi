package com.daffa.beritaapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffa.beritaapp.Api.Response.NewsResponse
import com.daffa.beritaapp.Api.Response.NewsResponseItem
import com.daffa.beritaapp.databinding.ActivityMainBinding
import com.daffa.beritaapp.databinding.ItemRowNewsBinding

class NewsAdapter(private val listNews: List<NewsResponseItem>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ItemRowNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemRowNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listNews[position]
        holder.binding.apply {
            tvCategory.text = data.tag
            tvTitle.text = data.title
            Glide.with(ivImage.context).load(data.thumb).into(ivImage)

        }
    }

    override fun getItemCount(): Int = listNews.size




}