package com.example.movieapp_kotlin.data.remote.client

import com.example.movieapp_kotlin.data.model.MovieDetails
import com.example.movieapp_kotlin.data.model.ResultsMovies
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface WebServices {
    @GET("/3/movie/{category}")
    suspend fun getMovies(
        @Path("category") category: String?,
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int
    ): ResultsMovies

    @GET("/3/movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?
    ): Single<MovieDetails?>?

    @GET("/3/movie/{movie_id}/similar")
    fun getSimilarMovies(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int
    ): Single<ResultsMovies?>?
}