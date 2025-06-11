package com.example.myweather.data.data_source

import com.example.myweather.data.dto.WeatherResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess

class WeatherRemoteDataSource(
    private val client: HttpClient
) {
    suspend fun fetchWeather( coordinate: Pair<String, String>): WeatherResponseDto {
        return try {
            val response: HttpResponse =
                client.get("${Consts.BASE_URL}${Consts.FORECAST_ENDPOINT}") {
                    url {
                        parameters.append("latitude", coordinate.first)
                        parameters.append("longitude", coordinate.second)
                        parameters.append("current", Consts.CURRENT_DATA_PARAMS)
                        parameters.append("hourly", Consts.HOURLY_DATA_PARAMS)
                        parameters.append("daily", Consts.DAILY_DATA_PARAMS)
                    }
                }
            if (response.status.isSuccess()) {
                response.body<WeatherResponseDto>()


            } else {
                val errorBody = response.bodyAsText()
                throw Exception("Failed to fetch weather data: API returned status ${response.status.value} - $errorBody")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception(
                "Network or data processing error: ${e.localizedMessage ?: e.message}", e
            )
        }
    }

    private object Consts {
        const val BASE_URL = "https://api.open-meteo.com/v1"
        const val FORECAST_ENDPOINT = "/forecast"
        const val CURRENT_DATA_PARAMS =
            "temperature_2m,weather_code,wind_speed_10m,relative_humidity_2m,apparent_temperature,is_day,precipitation,rain,showers,pressure_msl"
        const val HOURLY_DATA_PARAMS =
            "temperature_2m,weather_code,relative_humidity_2m,wind_speed_10m,apparent_temperature,precipitation_probability"
        const val DAILY_DATA_PARAMS =
            "weather_code,rain_sum,temperature_2m_max,temperature_2m_min,uv_index_max,apparent_temperature_max,apparent_temperature_min"
    }
}