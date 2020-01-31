package com.task.task.currentwheather.data

import com.task.task.database.Weather

interface ICurrentWeatherLocalDataSource {
     suspend fun SaveCurrentWeather(weather:Weather)
}