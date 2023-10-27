package com.example.journeyjoy.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.journeyjoy.data.localDb.Appdb
import com.example.journeyjoy.data.network_api.ApiMethodsInterface
import com.example.journeyjoy.models.CountryDataModel

class AppRepository(private val apiMethodsInterface: ApiMethodsInterface ,private val appdb: Appdb) {

    var response =MutableLiveData<CountryDataModel>()

    val getResponse: LiveData<CountryDataModel>
        get() = response


   suspend fun getcountryList() {
       val apiResponse = apiMethodsInterface.getCountyList()
       if (apiResponse.body() != null){
           response.postValue(apiResponse.body())
           appdb.appDao().insertData(apiResponse.body()!!)
       }

    }
}