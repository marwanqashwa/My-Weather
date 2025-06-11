package com.example.myweather.presentation.view_model

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.myweather.presentation.model.AnimationState
import kotlinx.coroutines.flow.MutableStateFlow

class AnimationViewModel:ViewModel() {
    private val _animationState = MutableStateFlow(AnimationState())
    val animationState = _animationState


    private val imgHeightInColumnState = 200.dp
    private val imgWidthInColumnState = 220.dp
    private val columnHighInColumnState = 143.dp
    private val columnWidthInRowState = 168.dp
    private val spaceBetweenInColumnState = 12.dp

    fun updateScroll(value: Int, screenWidth: Dp) {
        val raw = value.dp / 100.dp
        val progress = when {
            raw < 0f -> 0f
            raw > 1f -> 1f
            else -> raw
        }

        val imgHighInRowState =
            imgHeightInColumnState - (imgHeightInColumnState - columnHighInColumnState) * progress
        val imgWidthInRowState =
            imgWidthInColumnState - (imgWidthInColumnState - columnWidthInRowState) * progress

        val imgStartX = (screenWidth - imgWidthInColumnState - 30.dp) / 2
        val columnStartX = imgStartX + (imgWidthInColumnState - columnWidthInRowState) / 2
        val imgEndX = (-12).dp
        val columnEndX = screenWidth - columnWidthInRowState - 12.dp - 16.dp
        val imgX = imgStartX + (imgEndX - imgStartX) * progress
        val columnX = columnStartX + (columnEndX - columnStartX) * progress
        val columnY = (imgHeightInColumnState + 26.dp + spaceBetweenInColumnState) * (1f - progress)

        _animationState.value = AnimationState(
            scrollValue = value,
            progress = progress,
            imgWidthInRowState = imgWidthInRowState,
            imgHighInRowState = imgHighInRowState,
            imgX = imgX,
            columnX = columnX,
            columnY = columnY
        )
    }
}