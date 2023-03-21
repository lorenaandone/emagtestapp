package com.example.emagtestapp.presentation.movies.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.emagtestapp.data.movie.model.MovieRecommendationType
import com.example.emagtestapp.databinding.FragmentMoviesBinding
import com.example.emagtestapp.presentation.movies.listing.MovieUtils.movieRecommendationToDisplayedNameRes
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    private val viewModel: MovieListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            uiModel = this@MovieListFragment.viewModel.uiModel
        }
        setupMovieFilters()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun setupMovieFilters() {
        binding.movieFilters.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tag = tab?.tag as? MovieRecommendationType
                if (tag != null) {
                    viewModel.getMoviesByRecommendationType(tag)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //do-nothing
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //do-nothing
            }

        })

        MovieRecommendationType.values().forEachIndexed { index, type ->
            val displayedFilterName = requireContext().getString(movieRecommendationToDisplayedNameRes(type))
            val newTab = binding.movieFilters.newTab().apply {
                text = displayedFilterName
                tag = type
            }
            val selected = index == 0
            binding.movieFilters.addTab(newTab, selected)
        }
    }
}