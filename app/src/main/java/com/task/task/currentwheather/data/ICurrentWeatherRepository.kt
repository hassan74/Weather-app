package com.task.task.currentwheather.data

import com.task.task.database.Weather
import com.task.task.currentwheather.entities.ApiResponseBody

interface ICurrentWeatherRepository {
    suspend fun getCurrentWeather(counteryId :String ,key:String): ApiResponseBody<Weather>
    suspend fun saveCurrentWeather(Weather:Weather)
}