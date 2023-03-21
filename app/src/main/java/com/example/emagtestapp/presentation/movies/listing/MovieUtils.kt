package com.example.emagtestapp.presentation.movies.listing

import com.example.emagtestapp.R
import com.example.emagtestapp.data.movie.model.MovieRecommendationType

object MovieUtils {

    fun movieRecommendationToDisplayedNameRes(from: MovieRecommendationType): Int = when (from) {
        MovieRecommendationType.NOW_PLAYING -> R.string.filter_movie_now_playing
        MovieRecommendationType.POPULAR -> R.string.filter_movie_popular
        MovieRecommendationType.TOP_RATED -> R.string.filter_movie_top_rated
        MovieRecommendationType.UPCOMING -> R.string.filter_movie_upcoming
    }
}