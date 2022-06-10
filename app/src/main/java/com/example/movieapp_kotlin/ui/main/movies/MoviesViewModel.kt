package com.example.movieapp_kotlin.ui.main.movies

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.movieapp_kotlin.data.DataRepositort
import com.example.movieapp_kotlin.data.model.Genres
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.data.remote.client.ApiClient
import com.example.movieapp_kotlin.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel
@Inject
constructor(val dataRepositort: DataRepositort):BaseViewModel(dataRepositort) {

    private var moviesPagesList : LiveData<PagedList<Moviedata>> = MutableLiveData()
    private lateinit var moviesDataSourceFactory: MovieDataSourceFactory

    init {
        fetchMoviesPagedList()
    }

    fun fetchMoviesPagedList(){
        moviesDataSourceFactory = MovieDataSourceFactory("category")
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(ApiClient.MOVIE_PER_PAGE)
            .build()
      //  moviesPagesList = getDataManager().getApiRepository().fetchLiveMoviesPagedList(category)


        moviesPagesList = LivePagedListBuilder(moviesDataSourceFactory, config).build()


    }

    val moviesPagedListLiveData : LiveData<PagedList<Moviedata>> get() = moviesPagesList

}