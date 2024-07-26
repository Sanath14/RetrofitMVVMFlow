package com.appynitty.retrofitexample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appynitty.retrofitexample.api.PhotosApi
import com.appynitty.retrofitexample.model.PhotoData
import com.appynitty.retrofitexample.repository.PhotoRepository
import com.appynitty.retrofitexample.utils.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: PhotoRepository) : ViewModel() {

    val photosResult : MutableStateFlow<NetworkResult<List<PhotoData>?>> = MutableStateFlow(NetworkResult.Loading(false))
    init {
        viewModelScope.launch {
            repository.getPhotos().collect{
                photosResult.emit(it)
            }
        }
    }

}