package com.example.movieapp_kotlin.data.model.movie_details

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category (
    @SerializedName("id") @Expose
    val id: Int ,
    @SerializedName("name")
    @Expose
    val name: String
)