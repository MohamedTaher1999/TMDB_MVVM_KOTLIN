package com.example.movieapp_kotlin.data.remote

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.data.remote.client.ApiClient
import com.example.movieapp_kotlin.data.remote.client.WebServices
import com.example.movieapp_kotlin.ui.main.movies.MovieDataSourceFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository
@Inject
constructor(private val webServices: WebServices,movieDataSourceFactory: MovieDataSourceFactory)
{
    private lateinit var moviePagedList: LiveData<PagedList<Moviedata>>
    private lateinit var moviesDataSourceFactory: MovieDataSourceFactory

     fun fetchLiveMoviesPagedList (category: String) : LiveData<PagedList<Moviedata>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(ApiClient.MOVIE_PER_PAGE)
            .build()
        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()
        return moviePagedList
    }


}