package com.example.myweather.presentation.model

data class HourlyWeatherUiState(
    val hour: String,
    val temperature: Double,
    val weatherCode: Int,
)
