package com.example.randomquote.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.randomquote.repository.QuoteRepository

class MainViewModelFactory (private val repository: QuoteRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModelFactory(repository) as T
    }
}