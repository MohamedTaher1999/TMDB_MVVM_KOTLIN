package com.example.movieapp_kotlin.data.model.movie_details

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BasicMovieDetails  (
    @SerializedName("id")
    @Expose
    val id: Int ,

    @SerializedName("name")
    @Expose
    val name: String ,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String ,

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String

)
