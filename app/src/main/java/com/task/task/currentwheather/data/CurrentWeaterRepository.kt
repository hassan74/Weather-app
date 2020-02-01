package com.task.task.currentwheather.data

import com.task.task.database.Weather
import com.task.task.currentwheather.entities.ApiResponseBody
import io.reactivex.Single

class CurrentWeaterRepository(
    val currentWeatherRemoteDataSource: ICurrentWeatherRemoteDataSource,
    val currentWeatherLocalDataSource: ICurrentWeatherLocalDataSource
): ICurrentWeatherRepository {
    override suspend fun getCurrentWeather(counteryId :String ,key:String): ApiResponseBody<Weather> {
        return currentWeatherRemoteDataSource.getCurrentWeather(counteryId,key)
    }

    override fun getCurrentWeatherRxJava(
        counteryId: String,
        key: String
    ): Single<ApiResponseBody<Weather>> {
        return currentWeatherRemoteDataSource.getCurrentWeatherRxjava(counteryId ,key)
    }

    override suspend fun saveCurrentWeather(weather: Weather) {
        currentWeatherLocalDataSource.SaveCurrentWeather(weather )
    }


}