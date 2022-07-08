package com.example.movieapp_kotlin.data

import com.example.movieapp_kotlin.data.local.DatabaseRepository
import com.example.movieapp_kotlin.data.remote.ApiRepository
import com.example.movieapp_kotlin.data.remote.client.WebServices
import javax.inject.Inject

class DataRepository
@Inject
constructor(private val apiRepository: ApiRepository,private val databaseRepository: DatabaseRepository){


    fun getApiRepository():ApiRepository=apiRepository

    fun getdatabaseRepository():DatabaseRepository=databaseRepository


}