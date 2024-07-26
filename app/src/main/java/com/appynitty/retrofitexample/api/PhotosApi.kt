package com.appynitty.retrofitexample.api

import com.appynitty.retrofitexample.model.PhotoData
import retrofit2.Response
import retrofit2.http.GET

interface PhotosApi {

    @GET("photos")
    suspend fun getPhotos() : Response<List<PhotoData>>
}