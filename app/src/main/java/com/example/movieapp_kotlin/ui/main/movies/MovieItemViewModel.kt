package com.example.movieapp_kotlin.ui.main.movies

import android.view.View
import androidx.databinding.ObservableField
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.ui.base.BaseItemListener

class MovieItemViewModel(private val movie: Moviedata,
                         private val movieItemClickListener: MovieItemClickListener) {

    val moviePoster: ObservableField<String> = ObservableField<String>(movie.poster_path.toString())
    val movieTitle: ObservableField<String> = ObservableField<String>(movie.title.toString())

    fun onItemClick(view: View) {
        movieItemClickListener.onItemClick(view, movie)
    }

    interface MovieItemClickListener : BaseItemListener<Moviedata> {
        // to be implemented by the adapter.
    }

}