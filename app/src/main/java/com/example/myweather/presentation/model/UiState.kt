package com.example.myweather.presentation.model



data class UiState(
    val cityName:String="",
    val currentWeather: CurrentWeatherUiState= CurrentWeatherUiState(
        0.0,
        0,
        0.0,
        0,
        0.0,
        true,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0
    ),
    val hourlyForecast: List<HourlyWeatherUiState> = emptyList(),
    val dailyForecast: List<DailyWeatherUiState> = emptyList()
)
