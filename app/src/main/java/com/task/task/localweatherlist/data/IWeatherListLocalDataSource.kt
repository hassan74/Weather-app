package com.task.task.localweatherlist.data

import androidx.lifecycle.LiveData
import com.task.task.database.Weather

interface IWeatherListLocalDataSource {
     fun getWeatherList():LiveData<List<Weather>>
}