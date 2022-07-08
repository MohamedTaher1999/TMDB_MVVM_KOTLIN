package com.example.movieapp_kotlin.utils

import com.example.movieapp_kotlin.data.model.Moviedata

object AppConstants {
    var currentCategory="now_playing"
    var currentMovie:Moviedata?=null

    const val DATABASE_NAME="FavoriteMovies"
}