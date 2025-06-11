package com.example.myweather.presentation.model

data class DailyWeatherUiState(
    val day: String,
    val weatherCode: Int,
    val temperatureMax: Double,
    val temperatureMin: Double,
)
