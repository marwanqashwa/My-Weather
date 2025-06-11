package com.example.myweather.presentation.screen.composable.weatherScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.presentation.model.DailyWeatherUiState
import com.example.myweather.presentation.utils.getWeatherTitleFromWeatherCode
import com.example.myweather.ui.theme.WeatherColors
import com.example.myweather.ui.theme.urBanistMedium
import com.example.myweather.ui.theme.urBanistNormal


@Composable
fun NextDaysSection(
    colors: WeatherColors,
    modifier: Modifier = Modifier,
    daysWeather:List<DailyWeatherUiState>,
){
    Column(
        modifier
            .height(435.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(colors.dailyInfoCardBackgroundColor).border(
                width = 1.dp, color = colors.bordersColor, shape = RoundedCornerShape(24.dp)
            )

    ) {

        daysWeather.forEach{
            NextDaysItem(
                colors,
                Modifier.weight(1f),
                dayWeather = it,
            )

        }

    }
}

@Composable
private fun NextDaysItem(
    colors: WeatherColors,
    modifier: Modifier = Modifier,
    dayWeather:DailyWeatherUiState,
) {
    Box(
        modifier
            .fillMaxWidth()
            .drawBehind {
                drawLine(
                    color = colors.bordersColor,
                    start = Offset(0f,size.height),
                    end = Offset(size.width,size.height),
                    strokeWidth = 1.dp.toPx()
                )
            }.padding(horizontal = 16.dp)
    ) {
        Text(
            text = dayWeather.day,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier.align(Alignment.CenterStart).height(19.dp),
            textAlign = TextAlign.Start,
            fontFamily = urBanistNormal,
            color = colors.textDescription
        )
        Box(
            Modifier
                .size(91.dp, 45.dp)
                .align(Alignment.Center)

        ) {
            Image(
                painter = getWeatherTitleFromWeatherCode(dayWeather.weatherCode,true).img,
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center).height(45.dp),
                contentScale = ContentScale.Fit
            )
        }
        Row(Modifier.align(Alignment.CenterEnd).height(17.dp)) {
            Icon(
                painterResource(R.drawable.arrow_up),
                null,
                tint = colors.textTitle,
                modifier = Modifier
                    .size(12.dp, 12.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = "${dayWeather.temperatureMax.toInt()}°C",
                fontSize = 16.sp,
                lineHeight = 19.sp,
                letterSpacing = 0.25.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 4.dp, end = 8.dp),
                textAlign = TextAlign.Center,
                fontFamily = urBanistMedium,
                color = colors.textTitle
            )
            Box(
                Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .background(color = colors.separatorColor)
            )
            Spacer(Modifier.width(4.dp))
            Icon(
                painterResource(R.drawable.arrow_down),
                null,
                tint = colors.textTitle,
                modifier = Modifier
                    .size(12.dp, 12.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = "${dayWeather.temperatureMin.toInt()}°C",
                fontSize = 16.sp,
                lineHeight = 19.sp,
                letterSpacing = 0.25.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 4.dp),
                textAlign = TextAlign.Center,
                fontFamily = urBanistMedium,
                color = colors.textTitle
            )
        }
    }
}