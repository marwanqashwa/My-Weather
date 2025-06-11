package com.example.myweather.data.repository

import com.example.myweather.data.data_source.GoogleLocationDataSource
import com.example.myweather.data.utils.toDomain
import com.example.myweather.domain.model.LocationData
import com.example.myweather.domain.repository.LocationRepository

class LocationRepositoryImpl(private val dataSource:GoogleLocationDataSource):LocationRepository {
    override suspend fun getLocationDetails(): LocationData {
        return dataSource.getLocationDetails()?.toDomain()?:throw Exception("")
    }
}