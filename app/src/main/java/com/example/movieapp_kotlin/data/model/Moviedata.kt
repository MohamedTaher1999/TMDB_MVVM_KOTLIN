package com.example.movieapp_kotlin.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.movieapp_kotlin.data.model.collection
import com.example.movieapp_kotlin.data.model.Company
import com.example.movieapp_kotlin.data.model.Country
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.utils.AppConstants
import java.io.Serializable
import java.util.ArrayList

@Entity(tableName = AppConstants.DATABASE_NAME)
class Moviedata : Serializable {
    @Ignore
    var popularity: String? = null

    @Ignore
    var vote_count: String? = null

    @Ignore
    var video: String? = null

    @ColumnInfo(name = "poster_path")
    var poster_path: String? = null

    @PrimaryKey
    var id: Int = 0

    @Ignore
    var adult: String? = null

    @Ignore
    var backdrop_path: String? = null

    @Ignore
    var original_language: String? = null

    @Ignore
    var original_title: String? = null

    @Ignore
    var genre_ids: ArrayList<String>? = null

    @ColumnInfo(name = "title")
    var title: String? = null

    @Ignore
    var vote_average: String? = null

    @Ignore
    var overview: String? = null

    @Ignore
    var release_date: String? = null

    constructor() {}
    constructor(
        popularity: String?,
        vote_count: String?,
        video: String?,
        poster_path: String?,
        id: Int,
        adult: String?,
        backdrop_path: String?,
        original_language: String?,
        original_title: String?,
        genre_ids: ArrayList<String>?,
        title: String?,
        vote_average: String?,
        overview: String?,
        release_date: String?
    ) {
        this.popularity = popularity
        this.vote_count = vote_count
        this.video = video
        this.poster_path = poster_path
        this.id = id
        this.adult = adult
        this.backdrop_path = backdrop_path
        this.original_language = original_language
        this.original_title = original_title
        this.genre_ids = genre_ids
        this.title = title
        this.vote_average = vote_average
        this.overview = overview
        this.release_date = release_date
    }
}