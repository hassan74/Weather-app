package com.task.task.currentwheather.domain

import com.task.task.database.Weather
import com.task.task.currentwheather.data.ICurrentWeatherRepository
import com.task.task.currentwheather.entities.ApiResponseBody
import io.reactivex.Single

class CurrentWeatherUseCase (val currentWeaterRepository: ICurrentWeatherRepository) {
    suspend fun getWeatherCoroutines(counteryId:String, key :String): ApiResponseBody<Weather> {
        return currentWeaterRepository.getCurrentWeather(counteryId ,key)
    }

     fun getWeatherRxJava(counteryId:String, key :String): Single<ApiResponseBody<Weather>> {
        return currentWeaterRepository.getCurrentWeatherRxJava(counteryId ,key)
    }

    suspend fun saveWeather(weather: Weather){
        return currentWeaterRepository.saveCurrentWeather(weather)
    }
}