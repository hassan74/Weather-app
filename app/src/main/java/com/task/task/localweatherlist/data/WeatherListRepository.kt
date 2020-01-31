package com.task.task.localweatherlist.data

import androidx.lifecycle.LiveData
import com.task.task.database.Weather

class WeatherListRepository(
    val weatherListLocalDataSource: IWeatherListLocalDataSource) :IWeatherListRepository{
    override fun getWeatherList(): LiveData<List<Weather>> {
        return weatherListLocalDataSource.getWeatherList()
    }
}