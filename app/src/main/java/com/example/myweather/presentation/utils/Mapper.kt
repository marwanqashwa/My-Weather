package com.example.myweather.presentation.utils


import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myweather.domain.model.Weather
import com.example.myweather.presentation.model.CurrentWeatherUiState
import com.example.myweather.presentation.model.DailyWeatherUiState
import com.example.myweather.presentation.model.HourlyWeatherUiState
import com.example.myweather.presentation.model.UiState
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.TextStyle
import java.util.Date
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun Weather.toUi(): UiState {
    return UiState(cityName = cityName, currentWeather = CurrentWeatherUiState(
        currentWeather.temperature,
        currentWeather.weatherCode,
        currentWeather.windSpeed,
        currentWeather.relativeHumidity,
        currentWeather.apparentTemperature,
        currentWeather.isDay,
        currentWeather.precipitation,
        currentWeather.pressure,
        dailyForecast.first().temperatureMax,
        dailyForecast.first().temperatureMin,
        dailyForecast.first().uvIndexMax
    ), hourlyForecast = hourlyForecast.filter {
        val hour = it.time.split("T")[1]
        LocalTime.parse(hour).isAfter(
            LocalTime.parse(
                SimpleDateFormat("HH:mm", Locale.getDefault()).format(
                    Date()
                )
            )
        )
    }.map {
            HourlyWeatherUiState(
                hour = it.time.split("T")[1],
                temperature = it.temperature,
                weatherCode = it.weatherCode
            )
        }, dailyForecast = dailyForecast.map {
        DailyWeatherUiState(
            LocalDate.parse(it.time).dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH),
            it.weatherCode,
            it.temperatureMax,
            it.temperatureMin
        )
    })

}