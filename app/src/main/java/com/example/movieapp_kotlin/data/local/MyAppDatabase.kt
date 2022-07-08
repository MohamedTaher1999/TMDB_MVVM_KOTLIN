package com.example.movieapp_kotlin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp_kotlin.data.local.dao.MyDoa
import com.example.movieapp_kotlin.data.model.Moviedata

@Database(entities = [Moviedata::class], version = 1, exportSchema = false)
abstract class MyAppDatabase : RoomDatabase() {
    abstract val moviesDAO: MyDoa
}