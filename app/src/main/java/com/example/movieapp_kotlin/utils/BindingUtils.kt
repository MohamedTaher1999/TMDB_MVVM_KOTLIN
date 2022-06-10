package com.example.movieapp_kotlin.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.data.remote.client.ApiClient
import com.example.movieapp_kotlin.ui.base.BaseRecyclerViewAdapter
import com.example.movieapp_kotlin.ui.main.movies.MoviesAdapter

object BindingUtils {

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:posterSrc")
    fun setMoviePosterSrc(posterImage: ImageView, posterPath : String?){
        val moviePosterURL = "https://alwafd.news/images/thumbs/828/news/f984e83ce5b2fcfd0441e5e2d5dac729.jpg"
        Glide.with(posterImage.context)
            .load(moviePosterURL)
            .into(posterImage);
    }
    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:adapterList")
    fun setRecyclerViewData(recyclerView: RecyclerView , moviesList: LiveData<PagedList<Moviedata>>?){
        moviesList?.let {
            (recyclerView.adapter as? MoviesAdapter)?.apply {
                submitList(moviesList.value)
            }
        }
    }
    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:recyclerAdapter")
    fun <T> setRecyclerViewData(recyclerView: RecyclerView, items:MutableList <T>?) {
        items?.let { (recyclerView.adapter as BaseRecyclerViewAdapter<T>?)?.addItems(it) }
    }
}