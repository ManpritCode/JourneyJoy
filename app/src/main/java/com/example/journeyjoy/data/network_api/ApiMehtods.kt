package com.example.journeyjoy.data.network_api

import com.example.journeyjoy.models.DestinationModal
import retrofit2.Call
import retrofit2.http.GET

interface ApiMehtods {

    @GET("destination")
    fun getDestinations():Call<List<DestinationModal>>

}