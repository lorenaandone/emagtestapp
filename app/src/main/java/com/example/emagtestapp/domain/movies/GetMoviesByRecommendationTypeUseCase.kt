package com.example.emagtestapp.domain.movies

import com.example.emagtestapp.data.movie.MovieRepository
import com.example.emagtestapp.data.movie.model.MovieRecommendationType
import com.example.emagtestapp.data.movie.retrofit.MovieApiResponse
import com.example.emagtestapp.domain.Result
import com.example.emagtestapp.domain.movies.model.DomainMovie
import com.example.emagtestapp.domain.movies.model.toDomainMovie

class GetMoviesByRecommendationTypeUseCase(
    private val movieRepository: MovieRepository
) {
    suspend fun get(params: Params): Response {
        return try {
            val movies = movieRepository.getMoviesByRecommendationType(params.type.movieRecommendationType)
            Response(Result.Success(movies.map(MovieApiResponse::toDomainMovie)))
        } catch (ex: Throwable) {
            Response(Result.Error(ex))
        }
    }

    data class Params(val type: MovieRecommendationType)
    data class Response(val result: Result<List<DomainMovie>>)
}