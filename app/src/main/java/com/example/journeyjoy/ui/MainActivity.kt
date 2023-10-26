package com.example.journeyjoy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.journeyjoy.R
import com.example.journeyjoy.data.network_api.ApiMehtods
import com.example.journeyjoy.data.network_api.ServiceClient
import com.example.journeyjoy.models.DestinationModal
import com.example.journeyjoy.repository.AppRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         AppRepository().apply {
             val service = ServiceClient.ServiceProvide(ApiMehtods::class.java)
             val requestCall = service.getDestinations()
             requestCall.enqueue(object : Callback<List<DestinationModal>> {
                 override fun onResponse(
                     call: Call<List<DestinationModal>>,
                     response: Response<List<DestinationModal>>
                 ) {
                     if (response.isSuccessful){
                         Log.d("check",response.body().toString())
                     }


                 }

                 override fun onFailure(call: Call<List<DestinationModal>>, t: Throwable) {
                     Log.d("check",t.toString() )

                 }

             })
         }
    }
}