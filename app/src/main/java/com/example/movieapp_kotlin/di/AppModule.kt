package com.example.movieapp_kotlin.di

import com.example.movieapp_kotlin.data.remote.ApiRepository
import com.example.movieapp_kotlin.data.remote.client.ApiClient
import com.example.movieapp_kotlin.data.remote.client.WebServices
import com.example.movieapp_kotlin.ui.main.movies.MovieDataSource
import com.example.movieapp_kotlin.ui.main.movies.MovieDataSourceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): WebServices =
        Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WebServices::class.java)
    @Provides
    @Singleton
    fun provideMovieDataSourceInstance(webServices : WebServices): MovieDataSource =
        MovieDataSource(webServices)

    @Provides
    @Singleton
    fun provideMovieDataSourceFactoryInstance(movieDataSource: MovieDataSource): MovieDataSourceFactory =
        MovieDataSourceFactory(movieDataSource)

    @Provides
    @Singleton
    fun provideApiRepositoryInstance(webServices : WebServices,movieDataSourceFactory: MovieDataSourceFactory): ApiRepository =
        ApiRepository(webServices,movieDataSourceFactory)

}