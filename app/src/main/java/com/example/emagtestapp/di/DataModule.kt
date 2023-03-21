package com.example.emagtestapp.di

import com.example.emagtestapp.data.movie.DefaultMovieRepository
import com.example.emagtestapp.data.movie.MovieDataSource
import com.example.emagtestapp.data.movie.MovieRepository
import com.example.emagtestapp.data.movie.remote.MovieRemoteDataSource
import com.example.emagtestapp.data.movie.retrofit.MovieClient.Companion.createClient
import org.koin.dsl.module

val dataModule = module {

    single { createClient() }
    factory<MovieDataSource> { MovieRemoteDataSource(get()) }
    single<MovieRepository> { DefaultMovieRepository(get()) }
}