package com.example.myweather.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentUnitsDto(
    val time: String,
    val interval: String,
    @SerialName("temperature_2m")
    val temperature2m: String,
    @SerialName("weather_code")
    val weatherCode: String,
    @SerialName("wind_speed_10m")
    val windSpeed10m: String,
    @SerialName("relative_humidity_2m")
    val relativeHumidity2m: String,
    @SerialName("apparent_temperature")
    val apparentTemperature: String,
    @SerialName("is_day")
    val isDay: String,
    val precipitation: String,
    val rain: String,
    val showers: String,
    @SerialName("pressure_msl")
    val pressureMsl: String
)
