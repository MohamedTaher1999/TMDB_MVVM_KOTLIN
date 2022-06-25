package com.example.movieapp_kotlin.ui.main.favouriteMovies

import android.util.Log
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
    val favoriteMoviesList = MutableLiveData<MutableList<Moviedata>>()
    init {
        favoriteMoviesList.value=ArrayList()
        val test:MutableList<Moviedata> = arrayListOf()
        var genres:ArrayList<String>?=null
        genres?.add("1")
        favoriteMoviesList.value?.add(Moviedata("taher","dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd",genres,"dsd","dsd","dsd","dsd"))
        favoriteMoviesList.value?.add(Moviedata("dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd",genres,"dsd","dsd","dsd","dsd"))
        favoriteMoviesList.value?.add(Moviedata("dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd",genres,"dsd","dsd","dsd","dsd"))
        favoriteMoviesList.value?.add(Moviedata("dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd",genres,"dsd","dsd","dsd","dsd"))
        favoriteMoviesList.value?.add(Moviedata("dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd","dsd",genres,"dsd","dsd","dsd","dsd"))
        favoriteMoviesList.value=favoriteMoviesList.value
        Log.e("taher",favoriteMoviesList.toString())
    }

}