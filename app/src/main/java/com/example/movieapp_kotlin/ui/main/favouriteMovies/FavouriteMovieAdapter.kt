package com.example.movieapp_kotlin.ui.main.movies

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.movieapp_kotlin.BR
import com.example.movieapp_kotlin.R
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.databinding.FavoriteMovieCardBinding
import com.example.movieapp_kotlin.ui.base.BaseItemListener
import com.example.movieapp_kotlin.ui.base.BasePagedListAdapter
import com.example.movieapp_kotlin.ui.base.BaseRecyclerViewAdapter
import com.example.movieapp_kotlin.ui.base.BaseViewHolder
import com.example.movieapp_kotlin.ui.main.favouriteMovies.FavouriteMovieItemViewModel

class FavouriteMovieAdapter(items: MutableList<Moviedata>, private val favoritesAdapterListener: FavoritesAdapterListener): BaseRecyclerViewAdapter<Moviedata>(items)
{


    interface FavoritesAdapterListener  : BaseItemListener<Moviedata>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
       return MoviesViewHolder(FavoriteMovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun addItems(items: List<Moviedata>) {
        this.clearItems()
        super.addItems(items)
    }

    inner class MoviesViewHolder(private val itemFavoriteMovieBinding: FavoriteMovieCardBinding) : BaseViewHolder(itemFavoriteMovieBinding.root),
        FavouriteMovieItemViewModel.FavoriteMovieItemClickListener {

        override fun onBind(position: Int) {
            val movie: Moviedata = getItems()[position]
            itemFavoriteMovieBinding.favouriteMovieItemViewModel = FavouriteMovieItemViewModel(movie, this)
            itemFavoriteMovieBinding.executePendingBindings()
        }

        override fun onItemClick(view: View, item: Moviedata) {
            favoritesAdapterListener.onItemClick(view, item)
        }

    }
}
