package com.example.emagtestapp.di

import com.example.emagtestapp.presentation.movies.listing.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MovieListViewModel(get()) }
}