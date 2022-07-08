package com.example.movieapp_kotlin.ui.main.movieDetails

import android.os.Bundle
import android.transition.TransitionInflater
import android.transition.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp_kotlin.R
import com.example.movieapp_kotlin.databinding.FragmentDetailsBinding
import com.example.movieapp_kotlin.ui.base.BaseFragment
import com.example.movieapp_kotlin.BR
import com.example.movieapp_kotlin.data.model.Moviedata
import com.example.movieapp_kotlin.ui.main.movieDetails.similar_movies.SimilarMoviesAdapter
import com.example.movieapp_kotlin.utils.AppConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment :BaseFragment<FragmentDetailsBinding,MovieDetailsViewModel>(), SimilarMoviesAdapter.MoviesAdapterListener {

    private val movieDetailsViewModel : MovieDetailsViewModel by viewModels()
    private val similarMoviesAdapter = SimilarMoviesAdapter(mutableListOf() , this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // val args = MovieDetailsFragmentArgs.fromBundle(requireArguments())
       // movieDetailsViewModel =  getViewModel{ parametersOf(SavedStateHandle(mapOf(AppConstants.SELECTED_MOVIE to args.selectedMovie)))}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        initToolbar()
        return gerMRootView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(getViewDataBinding().rvSimilarMovies , similarMoviesAdapter , RecyclerView.HORIZONTAL)
    }

    private fun initToolbar() {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        val layout = getViewDataBinding().collapsingToolbar
        val toolbar = getViewDataBinding().toolbar
        val navController =
            activity?.let { Navigation.findNavController(it,R.id.nav_host_fragment) }
        val appBarConfiguration =
            navController?.graph?.let { AppBarConfiguration.Builder(it).build() }
        if (navController != null) {
            if (appBarConfiguration != null) {
                NavigationUI.setupWithNavController(layout, toolbar, navController, appBarConfiguration)
            }
        }
    }

    private fun initRecyclerView(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>, orientation: Int) {
        recyclerView.layoutManager = LinearLayoutManager(context, orientation, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    override val layoutId: Int
        get() = R.layout.fragment_details
    override val bindingVariable: Int
        get() = BR.detailsViewModel

    override fun getViewModel(): MovieDetailsViewModel {
        return movieDetailsViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }


    override fun onItemClick(view: View, item: Moviedata) {
        AppConstants.currentMovie=item
        val action = MovieDetailsFragmentDirections.actionDetailsFragmentSelf(item)
        getNavController().navigate(action)
    }

}