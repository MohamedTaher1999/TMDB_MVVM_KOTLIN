package com.example.movieapp_kotlin.data

import com.example.movieapp_kotlin.data.remote.ApiRepository
import com.example.movieapp_kotlin.data.remote.client.WebServices
import javax.inject.Inject

class DataRepository
@Inject
constructor(private val webServices: WebServices,private val apiRepository: ApiRepository){


    fun getApiRepository():ApiRepository=apiRepository




}