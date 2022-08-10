package com.daffa.beritaapp.Api.Data

import com.daffa.beritaapp.Api.Response.NewsResponse
import com.daffa.beritaapp.Api.Response.NewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("games/e-sport")
    fun getNews(): Call<List<NewsResponseItem>>

}