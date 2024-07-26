package com.appynitty.retrofitexample.repository

import android.util.Log
import com.appynitty.retrofitexample.api.PhotosApi
import com.appynitty.retrofitexample.model.PhotoData
import com.appynitty.retrofitexample.utils.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.io.IOException

class PhotoRepositoryImpl(private val api : PhotosApi) : PhotoRepository {

    override suspend fun getPhotos() = flow {
        emit(NetworkResult.Loading(true))
        try {
            val response = api.getPhotos()
            if (response.isSuccessful){
                emit(NetworkResult.Loading(false))
                emit(NetworkResult.Success(response.body()))
            }else{
                emit(NetworkResult.Failure(response.message()))
            }
        }catch (t: Throwable) {
            emit(NetworkResult.Failure("Network Failure"))
            emit(NetworkResult.Loading(false))
        }
    }.catch { e ->
        emit(NetworkResult.Loading(false))
        emit(NetworkResult.Failure("Something went wrong"))
    }
}