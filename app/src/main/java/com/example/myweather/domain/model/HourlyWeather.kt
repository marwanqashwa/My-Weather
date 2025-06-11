package com.example.myweather.domain.model

data class HourlyWeather(
    val time: String,
    val temperature: Double,
    val weatherCode: Int,
)
