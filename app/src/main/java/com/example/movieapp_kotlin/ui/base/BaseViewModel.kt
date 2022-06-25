package com.example.movieapp_kotlin.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.example.movieapp_kotlin.data.DataRepository

abstract  class BaseViewModel(private val dataRepositort: DataRepository) : ViewModel(){

    val isLoading = ObservableBoolean()

    fun getDataManager() : DataRepository = dataRepositort

    fun setIsLoading(isDataLoading:Boolean){
        isLoading.set(isDataLoading)
    }
}