package com.example.myweather.di


import com.example.myweather.data.data_source.GoogleLocationDataSource
import com.example.myweather.data.data_source.WeatherRemoteDataSource
import com.example.myweather.data.repository.LocationRepositoryImpl
import com.example.myweather.data.repository.WeatherRepositoryImpl
import com.example.myweather.domain.repository.LocationRepository
import com.example.myweather.domain.repository.WeatherRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single <GoogleLocationDataSource>{ GoogleLocationDataSource(androidContext()) }
    single { HttpClient(CIO) { install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true })} } }
    single<WeatherRemoteDataSource> { WeatherRemoteDataSource(get()) }
    single <LocationRepository>{ LocationRepositoryImpl(get()) }
    single <WeatherRepository>{ WeatherRepositoryImpl(get(),get()) }

}