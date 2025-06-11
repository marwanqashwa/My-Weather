package com.example.myweather.presentation.screen.composable.weatherScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.presentation.model.AnimationState
import com.example.myweather.presentation.utils.getWeatherTitleFromWeatherCode
import com.example.myweather.ui.theme.WeatherColors
import com.example.myweather.ui.theme.urBanistMedium
import com.example.myweather.ui.theme.urBanistSemiBold

@Composable
fun TopSectionWithAnimation(
    modifier: Modifier = Modifier,
    animationState: AnimationState,
    colors: WeatherColors,
    currentWeatherTemperature: Double,
    maxTemp: Double,
    minTemp: Double,
    weatherCode: Int,
    isDay: Boolean
) {
    Box(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .height(animationState.columnY + 143.dp + 24.dp)
    ) {
        Box(
            Modifier
                .offset(x = animationState.imgX, y = 0.dp)
                .size(250.dp, 250.dp)
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .blur(100.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                    .alpha(0.32f)
                    .background(color = colors.blurColor)
            )
            Image(
                painter = getWeatherTitleFromWeatherCode(weatherCode, isDay).img,
                contentDescription = null,
                modifier = Modifier.size(
                    animationState.imgWidthInRowState,
                    animationState.imgHighInRowState
                ),
                contentScale = ContentScale.FillBounds
            )
        }
        Box(
            Modifier
                .offset(x = animationState.columnX, y = animationState.columnY)
                .size(168.dp, 143.dp)
        ) {
            Column(Modifier.fillMaxSize()) {
                Text(
                    text = "${currentWeatherTemperature.toInt()}°C",
                    fontSize = 64.sp,
                    lineHeight = 77.sp,
                    letterSpacing = 0.25.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = urBanistSemiBold,
                    color = colors.textHeaders
                )
                Text(
                    text = getWeatherTitleFromWeatherCode(weatherCode, isDay).title,
                    fontSize = 16.sp,
                    lineHeight = 19.sp,
                    letterSpacing = 0.25.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = urBanistMedium,
                    color = colors.textDescription
                )
                MaxMinRow(colors, maxTemp = maxTemp, minTemp = minTemp)
            }
        }
    }
}

@Composable
private fun MaxMinRow(
    colors: WeatherColors,
    modifier: Modifier = Modifier,
    maxTemp: Double,
    minTemp: Double,
) {
    Row(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(100.dp))
            .background(color = colors.maxMinBoxBackground)
            .padding(vertical = 8.dp, horizontal = 24.dp)
    ) {

        Icon(
            painterResource(R.drawable.arrow_up),
            null,
            tint = colors.textDescription,
            modifier = Modifier
                .size(12.dp, 12.dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = "${maxTemp.toInt()}°C",
            fontSize = 16.sp,
            lineHeight = 19.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 4.dp, end = 8.dp),
            textAlign = TextAlign.Center,
            fontFamily = urBanistMedium,
            color = colors.textDescription
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
            tint = colors.textDescription,
            modifier = Modifier
                .size(12.dp, 12.dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = "${minTemp.toInt()}°C",
            fontSize = 16.sp,
            lineHeight = 19.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 4.dp),
            textAlign = TextAlign.Center,
            fontFamily = urBanistMedium,
            color = colors.textDescription
        )
    }
}