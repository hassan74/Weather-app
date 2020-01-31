package com.task.task.localweatherlist.domain

import androidx.lifecycle.LiveData
import com.task.task.database.Weather
import com.task.task.localweatherlist.data.IWeatherListRepository

class WeatherListUseCase(val weatherListRepository: IWeatherListRepository) {
    fun getWeathers():LiveData<List<Weather>>{
        return weatherListRepository.getWeatherList()
    }
}