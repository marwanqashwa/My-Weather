package com.example.myweather.presentation.screen.composable.weather_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.presentation.model.HourlyWeatherUiState
import com.example.myweather.presentation.utils.getWeatherTitleFromWeatherCode
import com.example.myweather.ui.theme.WeatherColors
import com.example.myweather.ui.theme.urBanistMedium
import com.example.myweather.ui.theme.urBanistSemiBold

@Composable
fun TodayHoursSection(
    modifier: Modifier = Modifier,
    colors: WeatherColors,
    hourly: List<HourlyWeatherUiState>,
    isDay: Boolean
) {
    Column(
        modifier
    ) {
        Text(
            text = "Today",
            fontSize = 20.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            textAlign = TextAlign.Start,
            fontFamily = urBanistSemiBold,
            color = colors.textHeaders
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(hourly.size) {
                HourlyBoxItem(
                    colors = colors,
                    hour = hourly[it].hour,
                    temp = hourly[it].temperature.toInt(),
                    weatherCode = hourly[it].weatherCode,
                    isDay = isDay
                )
            }
        }
    }
}

@Composable
private fun HourlyBoxItem(
    colors: WeatherColors,
    modifier: Modifier = Modifier,
    hour: String,
    temp: Int,
    weatherCode: Int,
    isDay: Boolean
) {
    Box(
        modifier.size(88.dp, 144.dp)
    ) {
        Box(
            Modifier
                .height(120.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(colors.hoursInfoCardBackgroundColor)
                .border(
                    width = 1.dp, color = colors.bordersColor, shape = RoundedCornerShape(20.dp)
                )
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        ) {
            Column(Modifier.align(Alignment.BottomCenter)) {
                Text(
                    text = "$temp°C",
                    fontSize = 16.sp,
                    letterSpacing = 0.25.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = urBanistMedium,
                    color = colors.textTitle
                )
                Text(
                    text = hour,
                    fontSize = 16.sp,
                    letterSpacing = 0.25.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = urBanistMedium,
                    color = colors.textDescription
                )
            }
        }

        Box(Modifier
            .size(20.dp, 60.dp)
            .blur(100.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded).alpha(0.32f)
            .background(color = colors.blurColor).align(Alignment.Center))

        Image(
            painter = getWeatherTitleFromWeatherCode(weatherCode, isDay).img,
            contentDescription = null,
            modifier = Modifier
                .size(64.dp, 58.dp)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.FillBounds
        )
    }
}