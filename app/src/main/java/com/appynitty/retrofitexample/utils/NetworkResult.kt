package com.appynitty.retrofitexample.utils

sealed class NetworkResult<out T> {

    data class Loading(val isLoading : Boolean) : NetworkResult<Nothing>()
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Failure<T>(val message: String) : NetworkResult<T>()

}