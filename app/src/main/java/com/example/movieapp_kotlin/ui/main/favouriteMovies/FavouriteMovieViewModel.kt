package com.example.movieapp_kotlin.ui.main.favouriteMovies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp_kotlin.data.DataRepository
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouriteMovieViewModel
@Inject
constructor(val dataRepositort: DataRepository): BaseViewModel(dataRepositort)
{
    val favoriteMoviesList : LiveData<MutableList<Moviedata>> by lazy{
        getDataManager().getdatabaseRepository().getLiveFavoriteMovies()
    }

}