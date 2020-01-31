package com.task.task.currentwheather.data

import com.task.task.database.Weather
import com.task.task.currentwheather.entities.ApiResponseBody

interface ICurrentWeatherRemoteDataSource {
    suspend fun getCurrentWeather(counteryId :String ,key:String): ApiResponseBody<Weather>
}