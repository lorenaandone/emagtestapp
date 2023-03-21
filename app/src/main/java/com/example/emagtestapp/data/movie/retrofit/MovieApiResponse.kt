package com.example.emagtestapp.data.movie.retrofit

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.util.Date

@Keep
data class MovieApiResponse(
    @SerializedName("id") val movieId: Int,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: Date,
    @SerializedName("vote_average") val voteAverage: Float,
)

data class MovieListApiResponse(
    @SerializedName("results") val movies: List<MovieApiResponse>
)