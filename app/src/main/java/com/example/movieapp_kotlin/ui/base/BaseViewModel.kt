package com.example.movieapp_kotlin.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.example.movieapp_kotlin.data.DataRepositort

abstract  class BaseViewModel(private val dataRepositort: DataRepositort) : ViewModel(){

    val isLoading = ObservableBoolean()

    fun getDataManager() : DataRepositort = dataRepositort

    fun setIsLoading(isDataLoading:Boolean){
        isLoading.set(isDataLoading)
    }
}