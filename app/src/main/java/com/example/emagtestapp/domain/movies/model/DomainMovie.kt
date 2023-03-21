package com.example.emagtestapp.domain.movies.model

import com.example.emagtestapp.data.movie.retrofit.MovieApiResponse
import com.google.gson.annotations.SerializedName
import java.util.*

data class DomainMovie(
    val movieId: Int,
    val posterPath: String,
    val releaseDate: Date,
    val voteAverage: Float,
)

fun MovieApiResponse.toDomainMovie() = DomainMovie(movieId, posterPath, releaseDate, voteAverage)
