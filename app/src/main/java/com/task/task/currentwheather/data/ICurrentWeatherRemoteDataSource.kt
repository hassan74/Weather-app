package com.task.task.currentwheather.data

import com.task.task.database.Weather
import com.task.task.currentwheather.entities.ApiResponseBody
import io.reactivex.Single

interface ICurrentWeatherRemoteDataSource {
    suspend fun getCurrentWeather(counteryId :String ,key:String): ApiResponseBody<Weather>
    fun getCurrentWeatherRxjava(counteryId :String ,key:String): Single<ApiResponseBody<Weather>>
}