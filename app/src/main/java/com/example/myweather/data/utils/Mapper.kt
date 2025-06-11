package com.example.myweather.data.utils

import com.example.myweather.data.dto.LocationDataDto
import com.example.myweather.data.dto.WeatherResponseDto
import com.example.myweather.domain.model.CurrentWeather
import com.example.myweather.domain.model.DailyWeather
import com.example.myweather.domain.model.HourlyWeather
import com.example.myweather.domain.model.LocationData
import com.example.myweather.domain.model.Weather

fun WeatherResponseDto.toDomain(cityName:String): Weather {
    val current = CurrentWeather(
        time = current.time,
        temperature = current.temperature2m,
        weatherCode = current.weatherCode,
        windSpeed = current.windSpeed10m,
        relativeHumidity = current.relativeHumidity2m,
        apparentTemperature = current.apparentTemperature,
        isDay = current.isDay == 1,
        precipitation = current.precipitation,
        pressure = current.pressureMsl
    )

    val hourly = hourly.time.indices.take(24).map { index ->
        HourlyWeather(
            time = hourly.time[index],
            temperature = hourly.temperature2m[index],
            weatherCode = hourly.weatherCode[index]
        )
    }

    val daily = daily.time.indices.map { index ->
        DailyWeather(
            time = daily.time[index],
            weatherCode = daily.weatherCode[index],
            temperatureMax = daily.temperature2mMax[index],
            temperatureMin = daily.temperature2mMin[index],
            uvIndexMax = daily.uvIndexMax[index]
        )
    }

    return Weather(
        cityName=cityName,
        latitude = latitude,
        longitude = longitude,
        utcOffsetSeconds = utcOffsetSeconds,
        timezone = timezone,
        timezoneAbbreviation = timezoneAbbreviation,
        elevation = elevation,
        currentWeather = current,
        hourlyForecast = hourly,
        dailyForecast = daily
    )
}
fun LocationDataDto.toDomain(): LocationData {
    return LocationData(
        this.latitude,this.longitude,this.city
    )
}