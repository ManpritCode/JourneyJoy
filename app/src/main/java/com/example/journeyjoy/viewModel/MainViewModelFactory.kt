package com.example.journeyjoy.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.journeyjoy.repository.AppRepository

class MainViewModelFactory( private val  appRepository: AppRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(appRepository) as T
    }
}