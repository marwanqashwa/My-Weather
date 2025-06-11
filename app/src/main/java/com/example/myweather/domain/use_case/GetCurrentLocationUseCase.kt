package com.example.myweather.domain.use_case

import com.example.myweather.domain.model.LocationData
import com.example.myweather.domain.repository.LocationRepository

class GetCurrentLocationUseCase(private val repository: LocationRepository) {
    suspend operator fun invoke():LocationData{
        return repository.getLocationDetails()
    }
}