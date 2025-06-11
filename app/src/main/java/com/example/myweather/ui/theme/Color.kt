package com.example.myweather.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)




val lightColors=WeatherColors(
     textHeaders = Color(0xFF060414),//
    textDescription = Color(0x99060414),
    textTitle = Color(0xDE060414),
    gradientBackGroundColors = listOf(
        Color(0xFF87CEFA), Color(0xFFFFFFFF)
    ),
    dailyInfoCardBackgroundColor = Color(0xB2FFFFFF),
    hoursInfoCardBackgroundColor =  Color(0xB2FFFFFF),
    nextDaysCardColor =Color(0xB2FFFFFF),
    cityTextColor = Color(0xFF323232),
    blurColor =Color(0xFF00619D),
    maxMinBoxBackground = Color(0x14060414),
    bordersColor = Color(0x14060414),
    separatorColor = Color(0x3D060414)
)


val darkColors=WeatherColors(
    textHeaders = Color(0xFFFFFFFF),//
    textDescription = Color(0x99FFFFFF),
    textTitle = Color(0xDEFFFFFF),
    gradientBackGroundColors = listOf(
        Color(0xFF060414), Color(0xFF0D0C19)
    ),
    dailyInfoCardBackgroundColor = Color(0xB2060414),
    hoursInfoCardBackgroundColor =  Color(0xB2060414),
    nextDaysCardColor =Color(0xB2060414),
    cityTextColor = Color(0xFFFFFFFF),
    blurColor = Color(0xFFC0B7FF),
    maxMinBoxBackground = Color(0x14FFFFFF),
    bordersColor = Color(0x14FFFFFF),
    separatorColor = Color(0x3DFFFFFF)

)
data class WeatherColors(
    val textHeaders: Color,
    val textDescription: Color,
    val textTitle: Color,
    val gradientBackGroundColors:List<Color>,
    val dailyInfoCardBackgroundColor:Color,
    val hoursInfoCardBackgroundColor:Color,
    val nextDaysCardColor:Color,
    val cityTextColor:Color,
    val blurColor:Color,
    val maxMinBoxBackground:Color,
    val bordersColor:Color,
    val separatorColor:Color
)
