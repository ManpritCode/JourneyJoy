package com.example.journeyjoy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.journeyjoy.models.CountryDataModel
import com.example.journeyjoy.repository.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val appRepository: AppRepository):ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            appRepository.getcountryList()
        }
    }
    val getResponse: LiveData<CountryDataModel>
        get() = appRepository.getResponse


}