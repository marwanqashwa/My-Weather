package com.example.myweather.domain.repository

import com.example.myweather.domain.model.LocationData


interface LocationRepository {
    suspend fun getLocationDetails():  LocationData
}