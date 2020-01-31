package com.task.task.currentwheather.domain

import com.task.task.database.Weather
import com.task.task.currentwheather.data.ICurrentWeatherRepository
import com.task.task.currentwheather.entities.ApiResponseBody

class CurrentWeatherUseCase (val currentWeaterRepository: ICurrentWeatherRepository) {
    suspend fun getWeather(counteryId:String, key :String): ApiResponseBody<Weather> {
        return currentWeaterRepository.getCurrentWeather(counteryId ,key)
    }

    suspend fun saveWeather(weather: Weather){
        return currentWeaterRepository.saveCurrentWeather(weather)
    }
}