package com.example.movieapp_kotlin.ui.main.movies

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.movieapp_kotlin.data.DataRepository
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.data.remote.client.ApiClient
import com.example.movieapp_kotlin.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel
@Inject
constructor(val moviesDataSourceFactory: MovieDataSourceFactory,val dataRepositort: DataRepository):BaseViewModel(dataRepositort) {

    private var moviesPagesList : LiveData<PagedList<Moviedata>> = MutableLiveData()


    init {
        setIsLoading(true)
        fetchMoviesPagedList()
    }

    fun fetchMoviesPagedList(){

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(ApiClient.MOVIE_PER_PAGE)
            .build()
        moviesPagesList = LivePagedListBuilder(moviesDataSourceFactory, config).build()
        setIsLoading(false)


    }

    val moviesPagedListLiveData : LiveData<PagedList<Moviedata>> get() = moviesPagesList

}