package com.example.myweather.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponseDto(
    val latitude: Double,
    val longitude: Double,
    @SerialName("generationtime_ms")
    val generationtimeMs: Double,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int,
    val timezone: String,
    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    val elevation: Double,
    @SerialName("current_units")
    val currentUnits: CurrentUnitsDto,
    val current: CurrentDto,
    @SerialName("hourly_units")
    val hourlyUnits: HourlyUnitsDto,
    val hourly: HourlyDto,
    @SerialName("daily_units")
    val dailyUnits: DailyUnitsDto,
    val daily: DailyDto
)
