package com.appynitty.retrofitexample.utils

import com.appynitty.retrofitexample.api.PhotosApi
import com.appynitty.retrofitexample.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val profileApi: PhotosApi by lazy {
        retrofit().create(PhotosApi::class.java)
    }

}