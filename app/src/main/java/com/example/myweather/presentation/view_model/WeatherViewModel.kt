package com.example.myweather.presentation.view_model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweather.domain.use_case.GetWeatherInfoUseCase
import com.example.myweather.presentation.model.UiState
import com.example.myweather.presentation.utils.toUi
import com.example.myweather.ui.theme.WeatherColors
import com.example.myweather.ui.theme.darkColors
import com.example.myweather.ui.theme.lightColors
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
class WeatherViewModel(private val getWeatherInfo: GetWeatherInfoUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState

    @RequiresApi(Build.VERSION_CODES.O)
    private suspend fun update(){
        _uiState.value = getWeatherInfo.invoke().toUi()
    }

    init {
        viewModelScope.launch {
            update()
        }
    }
    val colors: WeatherColors
        get() = if (uiState.value.currentWeather.isDay)  lightColors else darkColors

}

