package com.task.task.di.main

import com.task.task.database.WeatherDao
import com.task.task.localweatherlist.data.IWeatherListLocalDataSource
import com.task.task.localweatherlist.data.IWeatherListRepository
import com.task.task.localweatherlist.data.WeatherListLocalDataSource
import com.task.task.localweatherlist.data.WeatherListRepository
import com.task.task.localweatherlist.domain.WeatherListUseCase
import com.task.task.currentwheather.data.*
import com.task.task.currentwheather.domain.CurrentWeatherUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {



    @MainScope
    @Provides
    fun provideWeatherListUseCase(weatherListRepository: IWeatherListRepository): WeatherListUseCase {
        var weatherListUseCase= WeatherListUseCase(weatherListRepository)
        return weatherListUseCase
    }
    @MainScope
    @Provides
    fun provideWeatherListRepository(weatherListLocalDataSource: IWeatherListLocalDataSource): IWeatherListRepository {
        var weatherListRepository:IWeatherListRepository =WeatherListRepository(weatherListLocalDataSource)
        return weatherListRepository
    }
    @MainScope
    @Provides
    fun PorvideWeatherListLocalDataSource(weatherDao: WeatherDao): IWeatherListLocalDataSource {
        var weatherLocalDataSource:IWeatherListLocalDataSource=WeatherListLocalDataSource(weatherDao)
        return weatherLocalDataSource
    }
    //-----------------
    @MainScope
    @Provides
    fun provideWeatherService(retrofit :Retrofit):WeatherService{
        val weatherService:WeatherService by lazy {retrofit.create(WeatherService::class.java)}
        return weatherService
        //var weatherService:WeatherService =retrofit.create(WeatherService::class.java)
        }

    @MainScope
    @Provides
    fun provideCurrentWeatherLocalDataSource(weatherDao: WeatherDao): ICurrentWeatherLocalDataSource {
        var currentWeatherLocalDataSource :ICurrentWeatherLocalDataSource =CurrentWeatherLocalDataSource(weatherDao)
        return currentWeatherLocalDataSource
    }
    @MainScope
    @Provides
    fun provideCurrentWeatherRemoteDataSource(weatherService: WeatherService): ICurrentWeatherRemoteDataSource {
        var currentWeatherRemoteDataSource:ICurrentWeatherRemoteDataSource =CurrentWeatherRemoteDataSource(weatherService)
        return currentWeatherRemoteDataSource
    }
    @MainScope
    @Provides
    fun provideCurrentWeatherRepository(currentWeatherRemoteDataSource: ICurrentWeatherRemoteDataSource ,currentWeatherLocalDataSource: ICurrentWeatherLocalDataSource) : ICurrentWeatherRepository {
        var currentWeaterRepository:ICurrentWeatherRepository =CurrentWeaterRepository(currentWeatherRemoteDataSource ,currentWeatherLocalDataSource)
        return currentWeaterRepository
    }
    @MainScope
    @Provides
    fun provideCurrentWeatherUseCase(currentWeaterRepository :ICurrentWeatherRepository): CurrentWeatherUseCase {
        return CurrentWeatherUseCase(currentWeaterRepository )
    }


}