package com.example.myweather.di


import com.example.myweather.presentation.view_model.AnimationViewModel
import com.example.myweather.presentation.view_model.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { WeatherViewModel(get()) }
    viewModel<AnimationViewModel>() { AnimationViewModel() }
}