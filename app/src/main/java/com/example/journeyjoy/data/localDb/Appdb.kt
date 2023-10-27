package com.example.journeyjoy.data.localDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.journeyjoy.models.CountryDataModelItem


@Database(entities = [CountryDataModelItem::class], version = 1)
 abstract class Appdb:RoomDatabase() {

     abstract fun appDao():AppDao

     companion object{
         @Volatile
         var INSTANCE:Appdb?=null
         fun getInstance(context: Context):Appdb{
             if (INSTANCE == null){
                 synchronized(this){
                     INSTANCE = Room.databaseBuilder(context,Appdb::class.java,"appdp").build()
                 }
             }
           return  INSTANCE!!
         }

     }
}