package com.example.movieapp_kotlin.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.utils.AppConstants
import io.reactivex.Single

@Dao
interface MyDoa {
    @Insert
    fun insert(movie: Moviedata)

    @Query("select * from ${AppConstants.DATABASE_NAME}")
    fun loadAll(): LiveData<MutableList<Moviedata>>

    @Query("delete from ${AppConstants.DATABASE_NAME} where id = :movieID")
    fun delete(movieID: Int)

    @Query("select COUNT(*) from ${AppConstants.DATABASE_NAME} where id = :movieID")
    fun isExist(movieID: Int): Single<Int>
}