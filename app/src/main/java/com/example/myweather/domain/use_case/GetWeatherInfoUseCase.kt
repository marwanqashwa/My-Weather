package com.example.myweather.domain.use_case

import com.example.myweather.domain.model.Weather
import com.example.myweather.domain.repository.WeatherRepository

class GetWeatherInfoUseCase(private val repository: WeatherRepository) {
    suspend operator fun invoke():Weather{
        return repository.fetchWeather()
    }
}