package com.task.task.currentwheather.data

import com.task.task.database.Weather
import com.task.task.database.WeatherDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrentWeatherLocalDataSource(val weatherDao: WeatherDao):ICurrentWeatherLocalDataSource {
    override suspend fun SaveCurrentWeather(weather: Weather) {
        withContext(Dispatchers.IO){
            weatherDao.insertAll(weather)
        }
    }
}