package com.example.movieapp_kotlin.data.model

import java.util.*

class ResultsMovies(
    var page: String,
    var total_results: String,
    var total_pages: Int,
    var results: ArrayList<Moviedata>
)