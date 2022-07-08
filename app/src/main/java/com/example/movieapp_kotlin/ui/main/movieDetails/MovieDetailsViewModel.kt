package com.example.movieapp_kotlin.ui.main.movieDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movieapp_kotlin.data.DataRepository
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.data.model.movie_details.MovieDetails
import com.example.movieapp_kotlin.ui.base.BaseViewModel
import com.example.movieapp_kotlin.utils.AppConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.movieapp_kotlin.data.model.Result
import com.example.movieapp_kotlin.data.model.ResultsMovies

@HiltViewModel
class MovieDetailsViewModel
@Inject
constructor(val dataRepository:DataRepository) : BaseViewModel(dataRepository) {

    private val movieDetails : MutableLiveData<MovieDetails> = MutableLiveData()
    private val similarMoviesList : MutableLiveData<List<Moviedata>> = MutableLiveData()

    private val coroutineExceptionHandler = CoroutineExceptionHandler{_ , throwable ->
        Log.i("MovieDetailsViewModel Error" , "Response Handler Issue: " + throwable.localizedMessage)
    }

    init {
        fetchMovieDetails()
        fetchSimilarMovies()
    }

    val movieDetailsLiveData : LiveData<MovieDetails> get() = movieDetails

    fun fetchMovieDetails( ){
        viewModelScope.launch(coroutineExceptionHandler) {
            when(val result = getDataManager().getApiRepository().fetchLiveMovieDetailsData(AppConstants.currentMovie!!.id)){
                is Result.Success<MovieDetails> -> {
                    movieDetails.value = result.data
                }
                is Result.Error ->{
                    Log.i("Here" , result.message.toString())
                }
            }

        }
    }
    fun fetchSimilarMovies(){
        viewModelScope.launch(coroutineExceptionHandler) {
            when(val result = getDataManager().getApiRepository().fetchLiveSimilarMoviesList(AppConstants.currentMovie!!.id)){
                is Result.Success<ResultsMovies> -> {
                    similarMoviesList.value = result.data.results
                    Log.i("taher" , result.data.results.size.toString())
                }
                is Result.Error ->{
                    Log.i("Here" , "SimilarMovies Failed")
                }
            }
        }
    }
    val similarMoviesLiveData : LiveData<List<Moviedata>> get() = similarMoviesList

    val isFavoriteMovie : MutableLiveData<Boolean> by lazy {
        getDataManager().getdatabaseRepository().checkFavoriteMovie(AppConstants.currentMovie!!.id)
    }
    fun onFavoriteBtnClick() {
        if(isFavoriteMovie.value!!){
            getDataManager().getdatabaseRepository().deleteFavoriteMovie(AppConstants.currentMovie!!.id)
            isFavoriteMovie.postValue(false)
        }else{
            getDataManager().getdatabaseRepository().addFavoriteMovie(AppConstants.currentMovie!!)
            isFavoriteMovie.postValue(true)
        }
    }
}