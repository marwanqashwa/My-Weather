package com.example.myweather.presentation.screen.composable.weatherScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.presentation.model.CurrentWeatherUiState
import com.example.myweather.ui.theme.WeatherColors
import com.example.myweather.ui.theme.urBanistMedium
import com.example.myweather.ui.theme.urBanistNormal

@Composable
fun CurrentUnitsSection(
    modifier: Modifier=Modifier,
    colors: WeatherColors,
    currentWeatherUiState: CurrentWeatherUiState
){
    Column(modifier) {
        Row(
            Modifier
                .padding(bottom = 6.dp)) {
            DailyBoxItem(
                colors,
                Modifier.weight(1f),
                label = "${currentWeatherUiState.windSpeed} KM/h",
                description = "Wind",
                icon = painterResource(R.drawable.fast_wind)
            )
            Spacer(Modifier.width(6.dp))
            DailyBoxItem(
                colors,
                Modifier.weight(1f),
                label = "${currentWeatherUiState.relativeHumidity}%",
                description = "Humidity",
                icon = painterResource(R.drawable.humidity)

            )
            Spacer(Modifier.width(6.dp))
            DailyBoxItem(
                colors,
                Modifier.weight(1f),
                label = "${currentWeatherUiState.precipitation}%",
                description = "Rain",
                icon = painterResource(R.drawable.rain)
            )
        }
        Row{
            DailyBoxItem(
                colors,
                Modifier.weight(1f),
                label = "${currentWeatherUiState.uvIndex}",
                description = "UV Index",
                icon = painterResource(R.drawable.uv_02)
            )
            Spacer(Modifier.width(6.dp))
            DailyBoxItem(
                colors,
                Modifier.weight(1f),
                label = "${currentWeatherUiState.pressure.toInt()} hPa",
                description = "Pressure",
                icon = painterResource(R.drawable.arrow_down_05)

            )
            Spacer(Modifier.width(6.dp))
            DailyBoxItem(
                colors,
                Modifier.weight(1f),
                label = "${currentWeatherUiState.apparentTemperature.toInt()}°C",
                description = "Feels like",
                icon = painterResource(R.drawable.temperature)
            )
        }
    }
}
@Composable
private fun DailyBoxItem(
    colors: WeatherColors,
    modifier: Modifier = Modifier,
    label:String,
    description:String,
    icon:Painter
) {
    Column(
        modifier = modifier
            .height(115.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(colors.dailyInfoCardBackgroundColor)
            .border(width = 1.dp, color = colors.bordersColor, shape = RoundedCornerShape(24.dp))
            .padding(vertical = 16.dp, horizontal = 8.dp)

    ) {
        Icon(
            icon,
            null,
            tint = Color(0xFF87CEFA),
            modifier = Modifier
                .size(32.dp, 32.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = label,
            fontSize = 20.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            fontFamily = urBanistMedium,
            color = colors.textTitle
        )
        Text(
            text = description,
            fontSize = 14.sp,
            lineHeight = 14.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp),
            textAlign = TextAlign.Center,
            fontFamily = urBanistNormal,
            color = colors.textDescription
        )
    }
}