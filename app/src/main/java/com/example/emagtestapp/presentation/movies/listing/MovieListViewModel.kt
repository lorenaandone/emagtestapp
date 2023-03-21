package com.example.emagtestapp.presentation.movies.listing

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emagtestapp.data.movie.model.MovieRecommendationType
import com.example.emagtestapp.domain.movies.GetMoviesByRecommendationTypeUseCase
import com.example.emagtestapp.domain.Result
import com.example.emagtestapp.domain.movies.model.DomainMovie
import com.example.emagtestapp.presentation.movies.listing.model.toMovieItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val getMoviesByRecommendationType: GetMoviesByRecommendationTypeUseCase
) : ViewModel() {

    val uiModel: MovieListUiModel = MovieListUiModel()

    private var getMoviesJob: Job? = null

    fun getMoviesByRecommendationType(type: MovieRecommendationType) {
        cancelMovieRequestIfRunning()
        getMoviesJob = viewModelScope.launch {
            uiModel.isLoading.value = true
            when (val result =
                getMoviesByRecommendationType.get(GetMoviesByRecommendationTypeUseCase.Params(type)).result) {
                is Result.Success -> {
                    uiModel.movieAdapterItems.value = result.data.map(DomainMovie::toMovieItem)
                }
                is Result.Error -> {
                    //todo handle errors, for now just logging
                    Log.w("TEST", result.throwable.localizedMessage.orEmpty())
                }
            }
            uiModel.isLoading.value = false
        }
    }

    /**
     * if tabs change and a request is already running, we cancel it first
     */
    private fun cancelMovieRequestIfRunning() {
        val job = getMoviesJob
        if (job?.isActive == true) {
            job.cancel()
        }
    }
}