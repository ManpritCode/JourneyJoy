package com.example.journeyjoy.data.network_api

import com.example.journeyjoy.models.CountryDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiMethodsInterface {

    @GET("destination")
    suspend fun getCountyList(): Response<CountryDataModel>

}