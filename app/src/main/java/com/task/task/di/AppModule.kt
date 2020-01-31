package com.task.task.di

import android.app.Application
import androidx.room.Room
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.task.task.database.AppDatabase
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
import retrofit2.converter.gson.GsonConverterFactory

@Module
class   AppModule {
//    @Singleton


//    @Singleton
    @Provides
    fun provideWeatherDao(application: Application): WeatherDao {
        var db = Room.databaseBuilder(
            application,
            AppDatabase::class.java, "weather"
        ).build()
        return db.weatherDao()
    }

//    @Singleton
//    @Provides
//    fun getTestring() = "Test string"

    @Provides
    fun provideRetrofitInstance(): Retrofit {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
    //-----------------
    @Provides
    fun provideWeatherListUseCase(weatherListRepository: IWeatherListRepository): WeatherListUseCase {
        var weatherListUseCase= WeatherListUseCase(weatherListRepository)
        return weatherListUseCase
    }
    @Provides
    fun provideWeatherListRepository(weatherListLocalDataSource: IWeatherListLocalDataSource): IWeatherListRepository {
        var weatherListRepository:IWeatherListRepository =WeatherListRepository(weatherListLocalDataSource)
        return weatherListRepository
    }
    @Provides
    fun PorvideWeatherListLocalDataSource(weatherDao: WeatherDao): IWeatherListLocalDataSource {
        var weatherLocalDataSource:IWeatherListLocalDataSource=WeatherListLocalDataSource(weatherDao)
        return weatherLocalDataSource
    }
    //-----------------
    @Provides
    fun provideWeatherService(retrofit :Retrofit):WeatherService{
        val weatherService:WeatherService by lazy {retrofit.create(WeatherService::class.java)}
        return weatherService
        //var weatherService:WeatherService =retrofit.create(WeatherService::class.java)
        }

    @Provides
    fun provideCurrentWeatherLocalDataSource(weatherDao: WeatherDao): ICurrentWeatherLocalDataSource {
        var currentWeatherLocalDataSource :ICurrentWeatherLocalDataSource =CurrentWeatherLocalDataSource(weatherDao)
        return currentWeatherLocalDataSource
    }
    @Provides
    fun provideCurrentWeatherRemoteDataSource(weatherService: WeatherService): ICurrentWeatherRemoteDataSource {
        var currentWeatherRemoteDataSource:ICurrentWeatherRemoteDataSource =CurrentWeatherRemoteDataSource(weatherService)
        return currentWeatherRemoteDataSource
    }
    @Provides
    fun provideCurrentWeatherRepository(currentWeatherRemoteDataSource: ICurrentWeatherRemoteDataSource ,currentWeatherLocalDataSource: ICurrentWeatherLocalDataSource) : ICurrentWeatherRepository {
        var currentWeaterRepository:ICurrentWeatherRepository =CurrentWeaterRepository(currentWeatherRemoteDataSource ,currentWeatherLocalDataSource)
        return currentWeaterRepository
    }
    @Provides
    fun provideCurrentWeatherUseCase(currentWeaterRepository :ICurrentWeatherRepository): CurrentWeatherUseCase {
        return CurrentWeatherUseCase(currentWeaterRepository )
    }


}