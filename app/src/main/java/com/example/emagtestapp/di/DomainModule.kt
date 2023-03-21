package com.example.emagtestapp.di

import com.example.emagtestapp.domain.movies.GetMoviesByRecommendationTypeUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetMoviesByRecommendationTypeUseCase(get()) }
}
