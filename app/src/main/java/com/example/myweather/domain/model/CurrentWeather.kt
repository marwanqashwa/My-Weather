package com.example.myweather.domain.model

data class CurrentWeather(
    val time: String,
    val temperature: Double,
    val weatherCode: Int,
    val windSpeed: Double,
    val relativeHumidity: Int,
    val apparentTemperature: Double,
    val isDay: Boolean,
    val precipitation: Double,
    val pressure: Double
)
