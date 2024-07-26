package com.appynitty.retrofitexample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appynitty.retrofitexample.repository.PhotoRepository

class MainViewModelFactory(
    private val repository: PhotoRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}