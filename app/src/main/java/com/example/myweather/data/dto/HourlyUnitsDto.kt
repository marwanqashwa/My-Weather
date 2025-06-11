package com.example.myweather.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyUnitsDto(
    val time: String,
    @SerialName("temperature_2m")
    val temperature2m: String,
    @SerialName("weather_code")
    val weatherCode: String,
    @SerialName("relative_humidity_2m")
    val relativeHumidity2m: String,
    @SerialName("wind_speed_10m")
    val windSpeed10m: String,
    @SerialName("apparent_temperature")
    val apparentTemperature: String,
    @SerialName("precipitation_probability")
    val precipitationProbability: String
)
