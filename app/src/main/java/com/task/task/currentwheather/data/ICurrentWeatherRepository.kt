package com.task.task.currentwheather.data

import com.task.task.database.Weather
import com.task.task.currentwheather.entities.ApiResponseBody
import io.reactivex.Single

interface ICurrentWeatherRepository {
    suspend fun getCurrentWeather(counteryId :String ,key:String): ApiResponseBody<Weather>
     fun getCurrentWeatherRxJava(counteryId :String ,key:String): Single<ApiResponseBody<Weather>>
    suspend fun saveCurrentWeather(Weather:Weather)
}