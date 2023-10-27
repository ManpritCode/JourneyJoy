package com.example.journeyjoy.data.localDb

import androidx.room.Dao
import androidx.room.Insert
import com.example.journeyjoy.models.CountryDataModel
import com.example.journeyjoy.models.CountryDataModelItem

@Dao
interface AppDao {
    @Insert
    suspend fun insertData(list: List<CountryDataModelItem>)
}