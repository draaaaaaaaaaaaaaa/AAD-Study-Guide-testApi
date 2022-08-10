package com.daffa.beritaapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daffa.beritaapp.Api.Data.ApiConfig
import com.daffa.beritaapp.Api.Response.NewsResponse
import com.daffa.beritaapp.Api.Response.NewsResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val listNews = MutableLiveData<List<NewsResponseItem>>()

    fun getNewsModel() {
        ApiConfig().getApiService().getNews().enqueue(object : Callback<List<NewsResponseItem>> {
            override fun onResponse(call: Call<List<NewsResponseItem>>, response: Response<List<NewsResponseItem>>) {
                listNews.value = response.body()
            }

            override fun onFailure(call: Call<List<NewsResponseItem>>, t: Throwable) {

            }

        })
    }
    fun getListNews(): LiveData<List<NewsResponseItem>> = listNews
}