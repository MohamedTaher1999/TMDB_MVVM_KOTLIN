package com.example.movieapp_kotlin.ui.main.movies

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
import com.example.movieapp_kotlin.ui.base.BaseViewHolder

class MoviesAdapter(val itemListener: MoviesAdapterListener): BasePagedListAdapter()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder{
        return MoviesViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context) , R.layout.movie_card , parent , false))
    }

    interface MoviesAdapterListener : BaseItemListener<Moviedata>

    inner class MoviesViewHolder(private var itemMovieBinding: MovieCardBinding) : BaseViewHolder(itemMovieBinding.root) , MovieItemViewModel.MovieItemClickListener{

        private lateinit var movieItemViewModel: MovieItemViewModel

        override fun onBind(position: Int) {
            movieItemViewModel = getItem(position)?.let { MovieItemViewModel(it, this) }!!
            itemMovieBinding.setVariable(BR.moveitem , movieItemViewModel)
            itemMovieBinding.executePendingBindings()
        }

        override fun onItemClick(view: View, item: Moviedata) {
            itemListener.onItemClick(view,item)
        }

    }
}
