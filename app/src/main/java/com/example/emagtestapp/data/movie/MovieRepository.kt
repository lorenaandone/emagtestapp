package com.example.emagtestapp.data.movie

import com.example.emagtestapp.data.movie.retrofit.MovieApiResponse

interface MovieRepository {

    suspend fun getMoviesByRecommendationType(recommendationType: String): List<MovieApiResponse>
}

class DefaultMovieRepository(
    private val remoteDataSource: MovieDataSource
) : MovieRepository {
    override suspend fun getMoviesByRecommendationType(recommendationType: String): List<MovieApiResponse> =
        remoteDataSource.getMoviesByRecommendationType(recommendationType)

}