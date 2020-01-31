package com.task.task.currentwheather.data

import com.task.task.database.Weather
import com.task.task.currentwheather.entities.ApiResponseBody

class CurrentWeatherRemoteDataSource(val weatherService: WeatherService):ICurrentWeatherRemoteDataSource {
    override suspend fun getCurrentWeather(
        counteryId: String,
        key: String
    ): ApiResponseBody<Weather> {
        return weatherService.weathers(counteryId ,key)
    }
}