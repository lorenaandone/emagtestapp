package com.example.emagtestapp.data.movie.retrofit

import com.example.emagtestapp.data.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface MovieClient {

    @GET("movie/{recommendation_type}")
    suspend fun getMoviesByRecommendationType(
        @Path("recommendation_type") recommendationType: String,
        @Query("api_key") apiKey: String = MovieConfig.MOVIE_API_KEY
    ): MovieListApiResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = MovieConfig.MOVIE_API_KEY
    ): MovieApiResponse

    companion object {
        fun createClient(): MovieClient {
            val okHttpClient = createOkHttpClient()
            val retrofit = createRetrofit(
                okHttpClient = okHttpClient,
                baseUrl = MovieConfig.MOVIE_BASE_URL
            )
            return retrofit.create(MovieClient::class.java)
        }
    }
}

private fun createOkHttpClient() = OkHttpClient.Builder()
    .connectTimeout(Constants.TIMEOUT_SECONDS, TimeUnit.SECONDS)
    .readTimeout(Constants.TIMEOUT_SECONDS, TimeUnit.SECONDS)
    .writeTimeout(Constants.TIMEOUT_SECONDS, TimeUnit.SECONDS)
    .build()

private fun createRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
    val gson = GsonBuilder().create()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()
}
