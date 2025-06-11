package com.example.myweather.presentation.model

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AnimationState(
    val scrollValue: Int = 0,
    val progress: Float = 0f,
    val imgWidthInRowState: Dp = 0.dp,
    val imgHighInRowState: Dp = 0.dp,
    val imgX: Dp = 0.dp,
    val columnX: Dp = 0.dp,
    val columnY: Dp = 0.dp
)
