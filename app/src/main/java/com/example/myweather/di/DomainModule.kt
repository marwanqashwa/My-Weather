package com.example.myweather.di

import com.example.myweather.domain.use_case.GetWeatherInfoUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetWeatherInfoUseCase(get())
    }
}