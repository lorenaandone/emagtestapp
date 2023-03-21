package com.example.emagtestapp.presentation.movies.listing.model

import com.example.emagtestapp.data.movie.retrofit.MovieConfig.MOVIE_IMAGE_BASE_URL
import com.example.emagtestapp.domain.movies.model.DomainMovie
import java.util.*

data class MovieItem(
    val movieId: Int,
    val posterUrl: String,
    val displayedReleaseYear: String,
    val displayedAverageRating: String
)

fun DomainMovie.toMovieItem() = MovieItem(
    movieId = movieId,
    posterUrl = MOVIE_IMAGE_BASE_URL.plus(posterPath),
    displayedReleaseYear = releaseDate.extractYear().toString(),
    displayedAverageRating = voteAverage.toString()
)

private fun Date.extractYear(): Int {
    val calendar = Calendar.getInstance()
    calendar.time = this
    return calendar.get(Calendar.YEAR)
}
