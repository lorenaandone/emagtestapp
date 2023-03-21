package com.example.emagtestapp.data.movie

import com.example.emagtestapp.data.movie.retrofit.MovieApiResponse

interface MovieDataSource {
    suspend fun getMoviesByRecommendationType(recommendationType: String): List<MovieApiResponse>
}