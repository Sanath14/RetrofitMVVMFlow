package com.appynitty.retrofitexample.repository

import com.appynitty.retrofitexample.api.PhotosApi
import com.appynitty.retrofitexample.model.PhotoData
import com.appynitty.retrofitexample.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {

    suspend fun getPhotos() : Flow<NetworkResult<List<PhotoData>?>>

}