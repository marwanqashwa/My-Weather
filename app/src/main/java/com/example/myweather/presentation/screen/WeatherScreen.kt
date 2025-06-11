package com.example.myweather.presentation.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.presentation.model.AnimationState
import com.example.myweather.presentation.model.UiState
import com.example.myweather.presentation.screen.composable.weather_screen.CurrentUnitsSection
import com.example.myweather.presentation.screen.composable.weather_screen.NextDaysSection
import com.example.myweather.presentation.screen.composable.weather_screen.TodayHoursSection
import com.example.myweather.presentation.screen.composable.weather_screen.TopSectionLocation
import com.example.myweather.presentation.screen.composable.weather_screen.TopSectionWithAnimation
import com.example.myweather.presentation.view_model.AnimationViewModel
import com.example.myweather.presentation.view_model.WeatherViewModel
import com.example.myweather.ui.theme.WeatherColors
import com.example.myweather.ui.theme.urBanistSemiBold
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = koinViewModel(),
    animationViewModel: AnimationViewModel = koinViewModel()
) {

    val scrollState = rememberScrollState()
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val animationState by animationViewModel.animationState.collectAsState()
    LaunchedEffect(scrollState.value) {
        animationViewModel.updateScroll(scrollState.value, screenWidth)
    }

    val uiState by viewModel.uiState.collectAsState()

    val colors = viewModel.colors

    WeatherScreenContent(uiState, animationState, colors, scrollState)
}

@Composable
private fun WeatherScreenContent(
    uiState: UiState,
    animationState: AnimationState,
    colors: WeatherColors,
    scrollState: ScrollState
) {
    Scaffold {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(scrollState)
                .background(
                    brush = Brush.linearGradient(
                        colors = colors.gradientBackGroundColors
                    )
                )
        ) {
            Spacer(Modifier.height(64.dp))
            TopSectionLocation(
                Modifier.align(Alignment.CenterHorizontally), colors, uiState.cityName
            )

            Spacer(Modifier.height(12.dp))

            TopSectionWithAnimation(
                animationState = animationState,
                colors = colors,
                currentWeatherTemperature = uiState.currentWeather.temperature,
                maxTemp = uiState.currentWeather.maxTemperature,
                minTemp = uiState.currentWeather.minTemperature,
                weatherCode = uiState.currentWeather.weatherCode,
                isDay = uiState.currentWeather.isDay
            )

            CurrentUnitsSection(
                colors = colors,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 24.dp),
                currentWeatherUiState = uiState.currentWeather
            )

            TodayHoursSection(
                colors = colors,
                hourly = uiState.hourlyForecast,
                isDay = uiState.currentWeather.isDay
            )

            Text(
                text = "Next 7 days",
                fontSize = 20.sp,
                letterSpacing = 0.25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(top = 24.dp)
                    .padding(bottom = 12.dp),
                textAlign = TextAlign.Start,
                fontFamily = urBanistSemiBold,
                color = colors.textHeaders
            )

            NextDaysSection(
                colors,
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                uiState.dailyForecast,
            )

            Spacer(Modifier.height(32.dp))
        }
    }
}








