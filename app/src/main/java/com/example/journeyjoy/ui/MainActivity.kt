package com.example.journeyjoy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.journeyjoy.R
import com.example.journeyjoy.adapters.CountryListRecyclerViewAdapter
import com.example.journeyjoy.data.localDb.Appdb
import com.example.journeyjoy.data.network_api.ApiMethodsInterface
import com.example.journeyjoy.data.network_api.Apiclient
import com.example.journeyjoy.databinding.ActivityMainBinding
import com.example.journeyjoy.repository.AppRepository
import com.example.journeyjoy.viewModel.MainViewModel
import com.example.journeyjoy.viewModel.MainViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val servise = Apiclient.service().create(ApiMethodsInterface::class.java)
        val db = Appdb.getInstance(this)
        val repository = AppRepository(servise,db)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.getResponse.observe(this, Observer {
            binding.RvView.adapter = CountryListRecyclerViewAdapter(it)
        })
    }
}