package com.example.movieapp_kotlin.ui.main.movies

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.movieapp_kotlin.data.model.Moviedata


class MovieDataSourceFactory(val category: String) : DataSource.Factory<Int, Moviedata>()
{
    private val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Moviedata> {
        val movieDataSource = MovieDataSource(category)
        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}