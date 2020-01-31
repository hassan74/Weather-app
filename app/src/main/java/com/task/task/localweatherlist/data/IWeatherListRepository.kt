package com.task.task.localweatherlist.data

import androidx.lifecycle.LiveData
import com.task.task.database.Weather

interface IWeatherListRepository {
    fun getWeatherList(): LiveData<List<Weather>>
}