package com.example.movieapp_kotlin.di

import android.content.Context
import androidx.room.Room
import com.example.movieapp_kotlin.data.local.DatabaseRepository
import com.example.movieapp_kotlin.data.local.MyAppDatabase
import com.example.movieapp_kotlin.data.remote.ApiRepository
import com.example.movieapp_kotlin.data.remote.client.ApiClient
import com.example.movieapp_kotlin.data.remote.client.WebServices
import com.example.movieapp_kotlin.ui.main.movies.MovieDataSource
import com.example.movieapp_kotlin.ui.main.movies.MovieDataSourceFactory
import com.example.movieapp_kotlin.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    @Provides
    @Singleton
    fun provideDatabaseRepositoryInstance(appDatabase: MyAppDatabase): DatabaseRepository =
        DatabaseRepository(appDatabase)


    @Provides
    @Singleton
    fun provideMyAppDatabaseInstance(@ApplicationContext context:Context): MyAppDatabase =
        Room.databaseBuilder(context,MyAppDatabase::class.java,AppConstants.DATABASE_NAME)
            .allowMainThreadQueries().build()

}