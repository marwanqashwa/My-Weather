package com.example.myweather.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyUnitsDto(
    val time: String,
    @SerialName("weather_code")
    val weatherCode: String,
    @SerialName("rain_sum")
    val rainSum: String,
    @SerialName("temperature_2m_max")
    val temperature2mMax: String,
    @SerialName("temperature_2m_min")
    val temperature2mMin: String,
    @SerialName("uv_index_max")
    val uvIndexMax: String,
    @SerialName("apparent_temperature_max")
    val apparentTemperatureMax: String,
    @SerialName("apparent_temperature_min")
    val apparentTemperatureMin: String
)
