package com.example.myweather.presentation.model

data class CurrentWeatherUiState(
    val temperature: Double,
    val weatherCode: Int,
    val windSpeed: Double,
    val relativeHumidity: Int,
    val apparentTemperature: Double,
    val isDay: Boolean,
    val precipitation: Double,
    val pressure: Double,
    val maxTemperature: Double,
    val minTemperature: Double,
    val uvIndex:Double
)
