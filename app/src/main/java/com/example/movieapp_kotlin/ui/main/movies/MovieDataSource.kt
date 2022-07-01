package com.example.movieapp_kotlin.ui.main.movies

import android.util.Log
import android.widget.Toast
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.data.remote.client.ApiClient
import com.example.movieapp_kotlin.data.remote.client.WebServices
import com.example.movieapp_kotlin.utils.AppConstants
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDataSource
constructor( private val webServices: WebServices): PageKeyedDataSource<Int, Moviedata>()
{
    private val page = ApiClient.FIRST_PAGE

    private val coroutineExceptionHandler = CoroutineExceptionHandler{_ , throwable ->
        Log.i("Here" , "Response Handler Issue: " + throwable.localizedMessage)
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback:LoadInitialCallback<Int, Moviedata>
    ) {


        GlobalScope.launch (coroutineExceptionHandler){
            val moviesList =  webServices.getMovies(
                AppConstants.currentCategory ,
                ApiClient.API_KEY , ApiClient.LANGUAGE ,
                page).results
            callback.onResult(moviesList , null , page + 1)
        }

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Moviedata>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Moviedata>) {
        GlobalScope.launch (coroutineExceptionHandler){
            val dataResponse = webServices.getMovies(AppConstants.currentCategory, ApiClient.API_KEY , ApiClient.LANGUAGE ,
                params.key)
            if (dataResponse.total_pages >= params.key){
                callback.onResult(dataResponse.results , params.key + 1)
            }else{
                Log.i("Here" , "End of Pages")
            }
        }
    }

}