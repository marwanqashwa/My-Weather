package com.example.myweather.domain.model

data class DailyWeather(
    val time: String,
    val weatherCode: Int,
    val temperatureMax: Double,
    val temperatureMin: Double,
    val uvIndexMax: Double,
)
