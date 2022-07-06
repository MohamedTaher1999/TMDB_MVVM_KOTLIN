package com.example.movieapp_kotlin.ui.main.movieDetails.similar_movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.movieapp_kotlin.BR
import com.example.movieapp_kotlin.R
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.databinding.MovieCardBinding
import com.example.movieapp_kotlin.ui.base.BaseItemListener
import com.example.movieapp_kotlin.ui.base.BasePagedListAdapter
import com.example.movieapp_kotlin.ui.base.BaseRecyclerViewAdapter
import com.example.movieapp_kotlin.ui.base.BaseViewHolder
import com.example.movieapp_kotlin.ui.main.movies.MovieItemViewModel

class SimilarMoviesAdapter(moviesItems : MutableList<Moviedata>, private val moviesAdapterListener: MoviesAdapterListener):  BaseRecyclerViewAdapter<Moviedata>(moviesItems)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder{
        return MoviesViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context) , R.layout.movie_card , parent , false))
    }

    interface MoviesAdapterListener : BaseItemListener<Moviedata>

    inner class MoviesViewHolder(private var itemMovieBinding: MovieCardBinding) : BaseViewHolder(itemMovieBinding.root) , MovieItemViewModel.MovieItemClickListener{

        private lateinit var movieItemViewModel: MovieItemViewModel

        override fun onBind(position: Int) {
            val movie: Moviedata = getItems()[position]
            itemMovieBinding.moveitem=MovieItemViewModel(movie,this)
            itemMovieBinding.executePendingBindings()
        }

        override fun onItemClick(view: View, item: Moviedata) {
            moviesAdapterListener.onItemClick(view,item)
        }

    }
}
