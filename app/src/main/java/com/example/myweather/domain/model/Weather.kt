package com.example.myweather.domain.model

data class Weather(
    val cityName:String,
    val latitude: Double,
    val longitude: Double,
    val utcOffsetSeconds: Int,
    val timezone: String,
    val timezoneAbbreviation: String,
    val elevation: Double,
    val currentWeather: CurrentWeather,
    val hourlyForecast: List<HourlyWeather>,
    val dailyForecast: List<DailyWeather>
)
