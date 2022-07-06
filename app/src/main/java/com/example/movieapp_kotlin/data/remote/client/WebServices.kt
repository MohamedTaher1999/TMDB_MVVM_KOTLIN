package com.example.movieapp_kotlin.data.remote.client

import com.example.movieapp_kotlin.data.model.movie_details.MovieDetails
import com.example.movieapp_kotlin.data.model.ResultsMovies
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface WebServices {
    @GET("movie/{category}")
    suspend fun getMovies(
        @Path("category") category: String?,
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int
    ): ResultsMovies

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?
    ): MovieDetails

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int
    ): ResultsMovies
}