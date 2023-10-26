package com.example.journeyjoy.data.network_api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceClient {

    val baseUrl ="https://10.0.2.2:9000/"

    val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val  okHttpClient = OkHttpClient.Builder().addInterceptor(logger)

    val retrofitBuilder = Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient.build())

    val retrofitService = retrofitBuilder.build()

    fun <T> ServiceProvide(serviceType:Class<T>):T{
        return retrofitService.create(serviceType)
    }

}