package com.armandorochin.mapsshowcaseapp.di

import com.armandorochin.mapsshowcaseapp.data.remote.OpenRouteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASEURL = "https://api.openrouteservice.org/v2/directions/"

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideOpenRouteService(retrofit: Retrofit): OpenRouteService{
        return retrofit.create(OpenRouteService::class.java)
    }
}