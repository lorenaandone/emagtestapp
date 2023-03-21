package com.example.emagtestapp.data.movie.remote

import com.example.emagtestapp.data.movie.MovieDataSource
import com.example.emagtestapp.data.movie.retrofit.MovieClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRemoteDataSource(
    private val movieClient: MovieClient,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO // default value used in this particular case; can inject another dispatcher for testing purposes
) : MovieDataSource {
    override suspend fun getMoviesByRecommendationType(recommendationType: String) = withContext(ioDispatcher) {
        movieClient.getMoviesByRecommendationType(recommendationType).movies
    }
}