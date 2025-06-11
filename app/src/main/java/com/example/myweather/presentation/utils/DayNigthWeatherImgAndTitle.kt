package com.example.myweather.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.myweather.R
import com.example.myweather.presentation.model.WeatherTitleAndImages

@Composable
fun getWeatherTitleFromWeatherCode(weatherCode: Int, isDay: Boolean): WeatherTitleAndImages {
    return when (weatherCode) {
        0 -> WeatherTitleAndImages(
            "Clear Sky",
            img = if (isDay) painterResource(R.drawable.clear_sky_day) else painterResource(R.drawable.clear_sky_night)
        )
        1 -> WeatherTitleAndImages(
            "Mainly Clear",
            img = if (isDay) painterResource(R.drawable.mainly_clear_night1) else painterResource(R.drawable.mainly_clear_day1)
        )
        2 -> WeatherTitleAndImages(
            "Partly Cloudy",
            img = if (isDay) painterResource(R.drawable.partly_cloudy_day2) else painterResource(R.drawable.partly_cloudy_night2)
        )
        3 -> WeatherTitleAndImages(
            "Overcast",
            img = if (isDay) painterResource(R.drawable.overcast_day3) else painterResource(R.drawable.overcast_nigth3)
        )
        45 -> WeatherTitleAndImages(
            "Fog",
            img = if (isDay) painterResource(R.drawable.fog_day45) else painterResource(R.drawable.fog_nigth45)
        )
        48 -> WeatherTitleAndImages(
            "Depositing Rime Fog",
            img = if (isDay) painterResource(R.drawable.depositing_rime_fog_day48) else painterResource(R.drawable.depositing_rime_fog_nigth48)
        )
        51 -> WeatherTitleAndImages(
            "Light Drizzle",
            img = if (isDay) painterResource(R.drawable.drizzle_light_day51) else painterResource(R.drawable.drizzle_light_nigth51)
        )
        53 -> WeatherTitleAndImages(
            "Moderate Drizzle",
            img = if (isDay) painterResource(R.drawable.drizzle_moderate_day53) else painterResource(R.drawable.drizzle_moderate_nigth53)
        )
        55 -> WeatherTitleAndImages(
            "Dense Drizzle",
            img = if (isDay) painterResource(R.drawable.drizzle_intensity_day55) else painterResource(R.drawable.drizzle_moderate_nigth53)
        )
        56 -> WeatherTitleAndImages(
            "Light Freezing Drizzle",
            img = if (isDay) painterResource(R.drawable.freezing_drizzle_light_day56) else painterResource(R.drawable.freezing_drizzle_light_nigth56)
        )
        57 -> WeatherTitleAndImages(
            "Dense Freezing Drizzle",
            img = if (isDay) painterResource(R.drawable.freezing_drizzle_intensity_day57) else painterResource(R.drawable.freezing_drizzle_intensity_nigth57)
        )
        61 -> WeatherTitleAndImages(
            "Slight Rain",
            img = if (isDay) painterResource(R.drawable.rain_slight_day61) else painterResource(R.drawable.rain_slight_nigth61)
        )
        63 -> WeatherTitleAndImages(
            "Moderate Rain",
            img = if (isDay) painterResource(R.drawable.rain_moderate_day63) else painterResource(R.drawable.rain_moderate_nigth63)
        )
        65 -> WeatherTitleAndImages(
            "Heavy Rain",
            img = if (isDay) painterResource(R.drawable.rain_intensity_day65) else painterResource(R.drawable.rain_intensity_nigth65)
        )
        66 -> WeatherTitleAndImages(
            "Light Freezing Rain",
            img = if (isDay) painterResource(R.drawable.freezing_light_day66) else painterResource(R.drawable.freezing_light_day66)
        )
        67 -> WeatherTitleAndImages(
            "Heavy Freezing Rain",
            img = if (isDay) painterResource(R.drawable.freezing_heavy_day67) else painterResource(R.drawable.freezing_heavy_nigth67)
        )
        71 -> WeatherTitleAndImages(
            "Slight Snow Fall",
            img = if (isDay) painterResource(R.drawable.snow_fall_light_day71) else painterResource(R.drawable.snow_fall_light_nigth71)
        )
        73 -> WeatherTitleAndImages(
            "Moderate Snow Fall",
            img = if (isDay) painterResource(R.drawable.snow_fall_moderate_day73) else painterResource(R.drawable.snow_fall_moderate_nigth73)
        )
        75 -> WeatherTitleAndImages(
            "Heavy Snow Fall",
            img = if (isDay) painterResource(R.drawable.snow_fall_intensity_day75) else painterResource(R.drawable.snow_fall_intensity_nigth75)
        )
        77 -> WeatherTitleAndImages(
            "Snow Grains",
            img = if (isDay) painterResource(R.drawable.snow_grains_day77) else painterResource(R.drawable.snow_grains_nigth77)
        )
        80 -> WeatherTitleAndImages(
            "Slight Rain Showers",
            img = if (isDay) painterResource(R.drawable.rain_shower_slight_day80) else painterResource(R.drawable.rain_shower_slight_nigth80)
        )
        81 -> WeatherTitleAndImages(
            "Moderate Rain Showers",
            img = if (isDay) painterResource(R.drawable.rain_shower_moderate_day81) else painterResource(R.drawable.rain_shower_moderate_nigth81)
        )
        82 -> WeatherTitleAndImages(
            "Violent Rain Showers",
            img = if (isDay) painterResource(R.drawable.rain_shower_violent_day82) else painterResource(R.drawable.rain_shower_violent_nigth82)
        )
        85 -> WeatherTitleAndImages(
            "Slight Snow Showers",
            img = if (isDay) painterResource(R.drawable.snow_shower_slight_day85) else painterResource(R.drawable.snow_shower_slight_nigth85)
        )
        86 -> WeatherTitleAndImages(
            "Heavy Snow Showers",
            img = if (isDay) painterResource(R.drawable.snow_shower_heavy_day86) else painterResource(R.drawable.snow_shower_heavy_nigth86)
        )
        95 -> WeatherTitleAndImages(
            "Thunderstorm",
            img = if (isDay) painterResource(R.drawable.thunderstrom_slight_or_moderate_day95) else painterResource(R.drawable.thunderstrom_slight_or_moderate_nigth95)
        )
        96 -> WeatherTitleAndImages(
            "Thunderstorm with Slight Hail",
            img = if (isDay) painterResource(R.drawable.thunderstrom_with_slight_hail_day96) else painterResource(R.drawable.thunderstrom_with_slight_hail_nigth96)
        )
        99 -> WeatherTitleAndImages(
            "Thunderstorm with Heavy Hail",
            img = if (isDay) painterResource(R.drawable.thunderstrom_with_heavy_hail_day99) else painterResource(R.drawable.thunderstrom_with_heavy_hail_nigth99)
        )
        else -> WeatherTitleAndImages(
            "Unknown Weather",
            img = if (isDay) painterResource(R.drawable.clear_sky_day) else painterResource(R.drawable.clear_sky_night)
        )
    }
}
