package com.example.movieapp_kotlin.utils

import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp_kotlin.R
import com.example.movieapp_kotlin.data.model.Genres
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.data.remote.client.ApiClient
import com.example.movieapp_kotlin.ui.base.BaseRecyclerViewAdapter
import com.example.movieapp_kotlin.ui.main.movies.MoviesAdapter

object BindingUtils {

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:posterSrc")
    fun setMoviePosterSrc(posterImage: ImageView, posterPath : String?){
        Glide.with(posterImage.context)
            .load(ApiClient.POSTER_BASE_URL+posterPath)
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

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:backPosterUrl")
    fun loadBackPosterImage(backgroundPoster: ImageView, movieBackgroundPath: String?) {
        Glide
            .with(backgroundPoster.context)
            .load(ApiClient.BACKDROP_BASE_URL + movieBackgroundPath)
            .into(backgroundPoster)
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:setMovieCategory")
    fun setMovieCategory(movieCatagories:TextView, genres: List<Genres>?) {

        var categoriesHolder = ""
        if(genres!=null){

            for(caragory in genres)
                categoriesHolder+=caragory.name+", "

        }

        movieCatagories.text=categoriesHolder



    }
    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:setMovieStatueImage")
    fun setMovieStatueImage(movieStatueImage:ImageView, IsReleased: String?) {
        if(IsReleased!=null){

            if(IsReleased.equals("Released"))
                movieStatueImage.setImageResource(R.drawable.ic_released)
            else
                movieStatueImage.setImageResource(R.drawable.ic_un_released)

        }

    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:setRate")
    fun setRate(ratingBar:RatingBar, voteAvrage: Double?) {

        if (voteAvrage != null) {
            ratingBar.rating= (voteAvrage/2).toFloat()
        }


    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:setInteger")
    fun setInteger(textView: TextView, number: Int?) {
       textView.text= number.toString()
    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("android:setAdultText")
    fun setAdultText(movieAdult: TextView, isAdult: Boolean?) {
        if(isAdult!!){movieAdult.text="yes"}
        else movieAdult.text="No"
    }



}