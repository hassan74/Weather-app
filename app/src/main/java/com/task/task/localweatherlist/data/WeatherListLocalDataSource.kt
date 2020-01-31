package com.task.task.localweatherlist.data

import androidx.lifecycle.LiveData
import com.task.task.database.Weather
import com.task.task.database.WeatherDao

class WeatherListLocalDataSource(val weatherDao: WeatherDao):IWeatherListLocalDataSource {
    override fun getWeatherList(): LiveData<List<Weather>> {
       return weatherDao.getAll()
    }
}