package com.example.movieapp_kotlin.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.movieapp_kotlin.data.model.movie_details.MovieDetails
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.data.remote.client.ApiClient
import com.example.movieapp_kotlin.data.remote.client.WebServices
import com.example.movieapp_kotlin.ui.main.movies.MovieDataSourceFactory
import javax.inject.Inject
import javax.inject.Singleton
import com.example.movieapp_kotlin.data.model.Result
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
    suspend fun fetchLiveMovieDetailsData(movieID : Int) : Result<MovieDetails> {

         return try {
             val movieDetails = webServices.getMovieDetails(movieID , ApiClient.API_KEY , ApiClient.LANGUAGE)
             Result.Success(movieDetails)
         }catch (exception : Exception){
             Log.i("API Repo",exception.message.toString())
             Result.Error(exception.localizedMessage)
         }


    }



}