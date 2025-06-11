package com.example.myweather.data.repository


import com.example.myweather.data.data_source.WeatherRemoteDataSource
import com.example.myweather.data.utils.toDomain
import com.example.myweather.domain.model.Weather
import com.example.myweather.domain.repository.LocationRepository
import com.example.myweather.domain.repository.WeatherRepository


class WeatherRepositoryImpl(
    private val dataSource: WeatherRemoteDataSource,
    private val locationRepository: LocationRepository
) : WeatherRepository {
    override suspend fun fetchWeather(): Weather {
        val latAndLong= locationRepository.getLocationDetails()
        return dataSource.fetchWeather(
           Pair(latAndLong.latitude.toString(),latAndLong.longitude.toString())
        ).toDomain(cityName = latAndLong.city.toString())
    }

}