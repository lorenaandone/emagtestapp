package com.example.emagtestapp

import android.app.Application
import com.example.emagtestapp.di.dataModule
import com.example.emagtestapp.di.domainModule
import com.example.emagtestapp.di.viewModelModule
import org.koin.core.context.startKoin

class EmagTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            modules(
                listOf(
                    dataModule,
                    domainModule,
                    viewModelModule
                )
            )
        }
    }
}