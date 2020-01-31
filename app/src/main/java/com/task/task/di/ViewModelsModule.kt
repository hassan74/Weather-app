package com.task.task.di

import androidx.lifecycle.ViewModel
import com.task.task.localweatherlist.presentation.WeatherViewModel
import com.task.task.currentwheather.presentation.CurrentWeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(CurrentWeatherViewModel::class)
    abstract fun bindCurrentWeatherViewModel(viewModel: CurrentWeatherViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    abstract fun bindWeatherListViewModel(viewModel: WeatherViewModel): ViewModel
}