package com.task.task.currentwheather.data

import com.task.task.database.Weather
import com.task.task.currentwheather.entities.ApiResponseBody

class CurrentWeaterRepository(
    val currentWeatherRemoteDataSource: ICurrentWeatherRemoteDataSource,
    val currentWeatherLocalDataSource: ICurrentWeatherLocalDataSource
): ICurrentWeatherRepository {
    override suspend fun getCurrentWeather(counteryId :String ,key:String): ApiResponseBody<Weather> {
        return currentWeatherRemoteDataSource.getCurrentWeather(counteryId,key)
    }

    override suspend fun saveCurrentWeather(weather: Weather) {
        currentWeatherLocalDataSource.SaveCurrentWeather(weather )
    }


}