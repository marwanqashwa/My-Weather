package com.example.myweather.presentation.screen.composable.weatherScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.WeatherColors
import com.example.myweather.ui.theme.urBanistMedium

@Composable
fun TopSectionLocation(
    modifier: Modifier=Modifier,
    colors:WeatherColors,
    cityName:String
){
    Row(modifier) {
        Icon(
            painterResource(R.drawable.location_ic), null, tint = colors.cityTextColor
        )
        Text(
            text = cityName,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.Bottom),
            textAlign = TextAlign.Center,
            fontFamily = urBanistMedium,
            color = colors.cityTextColor
        )
    }
}