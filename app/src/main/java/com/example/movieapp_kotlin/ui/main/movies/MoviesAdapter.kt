package com.example.movieapp_kotlin.ui.main.movies

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.ui.base.BaseRecyclerViewAdapter
import com.example.movieapp_kotlin.ui.base.BaseViewHolder

class MoviesAdapter(items:MutableList<Moviedata>): BaseRecyclerViewAdapter<Moviedata>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

    }

    inner class MoviesViewHolder(item: View):BaseViewHolder(item){
        override fun onBind(position: Int) {

        }
    }
}