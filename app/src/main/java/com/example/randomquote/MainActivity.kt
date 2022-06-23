package com.example.randomquote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.randomquote.api.QuoteService
import com.example.randomquote.api.RetrofitHelper
import com.example.randomquote.repository.QuoteRepository
import com.example.randomquote.viewmodel.MainViewModel
import com.example.randomquote.viewmodel.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)

        val repository = QuoteRepository(quoteService)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository))
            .get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this) {
            Log.d("Quotes!!", it.results.toString())
        }
    }
}