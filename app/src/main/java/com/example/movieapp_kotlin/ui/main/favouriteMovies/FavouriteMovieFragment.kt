package com.example.movieapp_kotlin.ui.main.favouriteMovies

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.movieapp_kotlin.R
import com.example.movieapp_kotlin.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import com.example.movieapp_kotlin.BR
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.databinding.FragmentFavouriteMovieBinding
import com.example.movieapp_kotlin.ui.main.movies.FavouriteMovieAdapter
import com.example.movieapp_kotlin.utils.AppConstants
import com.example.movieapp_kotlin.utils.GridLayoutManagerWrapper


@AndroidEntryPoint
class FavouriteMovieFragment : BaseFragment<FragmentFavouriteMovieBinding, FavouriteMovieViewModel>() ,
    FavouriteMovieAdapter.FavoritesAdapterListener {


    private val favouriteMovieViewModel: FavouriteMovieViewModel by viewModels()
    private val favouriteMovieAdapter: FavouriteMovieAdapter =  FavouriteMovieAdapter(mutableListOf(),this)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMoviesRecyclerView()



    }
    private fun initMoviesRecyclerView() {
        val gridLayoutManager = GridLayoutManagerWrapper(getMContext(), 2)
        getViewDataBinding().fmoviesRecycleView.layoutManager = gridLayoutManager
        getViewDataBinding().fmoviesRecycleView.setHasFixedSize(true)

        val animID: Int = R.anim.layout_animation_fall_down
        val animation = AnimationUtils.loadLayoutAnimation(context, animID)
        getViewDataBinding().fmoviesRecycleView.layoutAnimation = animation

        getViewDataBinding().fmoviesRecycleView.adapter = favouriteMovieAdapter
    }


    override val layoutId: Int
        get() = R.layout.fragment_favourite_movie
    override val bindingVariable: Int
        get() = BR.favouriteMovieViewModel
    override fun getViewModel(): FavouriteMovieViewModel {
        return favouriteMovieViewModel
    }

    override fun onItemClick(view: View, item: Moviedata) {

        view.transitionName = item.poster_path
        AppConstants.currentMovie=item
        val extras = FragmentNavigatorExtras(view to item.poster_path.toString())
        val action = FavouriteMovieFragmentDirections.actionFavouriteMovieFragmentToDetailsFragment(item)
        getNavController().navigate(action,extras)
    }


}