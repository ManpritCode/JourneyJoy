package com.example.journeyjoy.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contrydatamodelitem")
data class CountryDataModelItem(

    @PrimaryKey(autoGenerate = true)
    val userId:Int,
    val id: Int,
    val city: String,
    val country: String,
    val description: String,
)