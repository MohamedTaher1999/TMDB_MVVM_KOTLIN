package com.example.movieapp_kotlin.ui.main.movies

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.data.remote.client.WebServices
import javax.inject.Inject


class MovieDataSourceFactory

constructor( private val movieDataSource: MovieDataSource) : DataSource.Factory<Int, Moviedata>()
{
    private val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Moviedata> {
        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}