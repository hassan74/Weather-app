package com.task.task.currentwheather.data

import com.task.task.currentwheather.entities.ApiResponseBody
import com.task.task.database.Weather
import retrofit2.http.GET
import retrofit2.http.Query

public interface WeatherService {
    @GET("weather?")
     suspend fun weathers(@Query ("q")counteryId:String ,@Query("APPID")key:String) : ApiResponseBody<Weather>
    //fun weathers(@Query ("q")counteryId:String ,@Query("APPID")key:String) : Deferred<ApiResponseBody<Weather>>;
}