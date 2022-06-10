package com.example.movieapp_kotlin.ui.main.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.movieapp_kotlin.R
import com.example.movieapp_kotlin.databinding.FragmentMoviesBinding
import com.example.movieapp_kotlin.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import com.example.movieapp_kotlin.BR
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.tmdbcleanarchitecture.utils.GridLayoutManagerWrapper
import com.example.tmdbcleanarchitecture.utils.GridSpacingItemDecorationUtils


@AndroidEntryPoint
class MoviesFragment : BaseFragment<FragmentMoviesBinding, MoviesViewModel>() , MoviesAdapter.MoviesAdapterListener {

    private val moviesViewModel: MoviesViewModel by viewModels()
    private val moviesAdapter: MoviesAdapter =  MoviesAdapter(this)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMoviesRecyclerView(2, 25)



    }
    private fun initMoviesRecyclerView(spanCount: Int, spacing: Int) {
        val gridLayoutManager = GridLayoutManagerWrapper(getMContext(), spanCount)
        getViewDataBinding().moviesRecycleView.layoutManager = gridLayoutManager
        getViewDataBinding().moviesRecycleView.setHasFixedSize(true)
        // set Animation to all children (items) of this Layout
        val animID: Int = R.anim.layout_animation_fall_down
        val animation = AnimationUtils.loadLayoutAnimation(context, animID)
        getViewDataBinding().moviesRecycleView.layoutAnimation = animation
        // equal spaces between grid items
        val includeEdge = true
        val gridSpacingItemDecorationUtils = GridSpacingItemDecorationUtils(spanCount , spacing , includeEdge)
        getViewDataBinding().moviesRecycleView.addItemDecoration(gridSpacingItemDecorationUtils)
        getViewDataBinding().moviesRecycleView.adapter = moviesAdapter
    }


    override val layoutId: Int
        get() = R.layout.fragment_movies
    override val bindingVariable: Int
        get() = BR.moviesViewModel
    override fun getViewModel(): MoviesViewModel {
        return moviesViewModel
    }

    override fun onItemClick(view: View, item: Moviedata) {
        TODO("Not yet implemented")
    }


}