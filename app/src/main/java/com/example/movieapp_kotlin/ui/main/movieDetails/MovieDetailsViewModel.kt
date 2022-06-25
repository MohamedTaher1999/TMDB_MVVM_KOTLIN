package com.example.movieapp_kotlin.ui.main.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp_kotlin.data.DataRepository
import com.example.movieapp_kotlin.data.model.MovieDetails
import com.example.movieapp_kotlin.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel
@Inject
constructor(val dataRepositort:DataRepository) : BaseViewModel(dataRepositort) {

    private val movieDetails : MutableLiveData<MovieDetails> = MutableLiveData()

    init {
        fetchMovieDetails()

    }

    val movieDetailsLiveData : LiveData<MovieDetails> get() = movieDetails

    fun fetchMovieDetails(){

    }

}