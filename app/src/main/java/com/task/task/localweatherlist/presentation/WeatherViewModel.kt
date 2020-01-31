package com.task.task.localweatherlist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.task.task.database.Weather
import com.task.task.database.WeatherDao
import com.task.task.localweatherlist.domain.WeatherListUseCase
import javax.inject.Inject

class WeatherViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var listUseCase: WeatherListUseCase

    val weatherLiveData : LiveData<List<Weather>>
        get() = listUseCase.getWeathers()

}