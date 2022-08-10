package com.daffa.beritaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.beritaapp.Adapter.NewsAdapter
import com.daffa.beritaapp.Api.Response.NewsResponse
import com.daffa.beritaapp.Api.Response.NewsResponseItem
import com.daffa.beritaapp.ViewModel.MainViewModel
import com.daffa.beritaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? =null
    private val binding get() = _binding as ActivityMainBinding

    private var _viewModel: MainViewModel? = null
    private val viewModel get() = _viewModel as MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        _viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContentView(binding.root)

        val searchNews = "news"

        _viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getNewsModel()
        viewModel.getListNews().observe(this) {
            showData(it)
        }
    }

    private fun showData(data: List<NewsResponseItem>) {
        Log.d("MainActivity", "showData: $data")
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = NewsAdapter(data)
        }
    }
}
