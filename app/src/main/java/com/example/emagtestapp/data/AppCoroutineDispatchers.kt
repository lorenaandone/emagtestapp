package com.example.emagtestapp.data

import kotlinx.coroutines.CoroutineDispatcher

data class AppCoroutineDispatchers constructor(
    val io: CoroutineDispatcher,
    val computation: CoroutineDispatcher,
    val main: CoroutineDispatcher
)
