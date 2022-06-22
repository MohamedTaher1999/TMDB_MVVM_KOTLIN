package com.example.movieapp_kotlin.ui.main.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp_kotlin.data.DataRepositort
import com.example.movieapp_kotlin.data.model.MovieDetails
import com.example.movieapp_kotlin.ui.base.BaseViewModel

class MovieDetailsViewModel(val dataRepositort:DataRepositort) : BaseViewModel(dataRepositort) {

    private val movieDetails : MutableLiveData<MovieDetails> = MutableLiveData()

    init {
        fetchMovieDetails()

    }

    val movieDetailsLiveData : LiveData<MovieDetails> get() = movieDetails

    fun fetchMovieDetails(){

    }

}