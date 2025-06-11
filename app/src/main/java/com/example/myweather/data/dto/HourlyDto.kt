package com.example.myweather.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyDto(
    val time: List<String>,
    @SerialName("temperature_2m")
    val temperature2m: List<Double>,
    @SerialName("weather_code")
    val weatherCode: List<Int>,
    @SerialName("relative_humidity_2m")
    val relativeHumidity2m: List<Int>,
    @SerialName("wind_speed_10m")
    val windSpeed10m: List<Double>,
    @SerialName("apparent_temperature")
    val apparentTemperature: List<Double>,
    @SerialName("precipitation_probability")
    val precipitationProbability: List<Int>
)
