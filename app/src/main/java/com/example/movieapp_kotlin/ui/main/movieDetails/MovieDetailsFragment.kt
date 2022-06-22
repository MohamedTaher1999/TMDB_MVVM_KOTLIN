package com.example.movieapp_kotlin.ui.main.movieDetails

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.movieapp_kotlin.R
import com.example.movieapp_kotlin.databinding.FragmentDetailsBinding
import com.example.movieapp_kotlin.ui.base.BaseFragment
import com.example.movieapp_kotlin.BR

class MovieDetailsFragment :BaseFragment<FragmentDetailsBinding,MovieDetailsViewModel>() {

    private val movieDetailsViewModel : MovieDetailsViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val args = Detalis.fromBundle(requireArguments())
       // movieDetailsViewModel =  getViewModel{ parametersOf(SavedStateHandle(mapOf(AppConstants.SELECTED_MOVIE to args.selectedMovie)))}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        initToolbar()
        return gerMRootView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initToolbar() {
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


    override val layoutId: Int
        get() = R.layout.fragment_details
    override val bindingVariable: Int
        get() = BR.detailsViewModel

    override fun getViewModel(): MovieDetailsViewModel {
        return movieDetailsViewModel
    }

}