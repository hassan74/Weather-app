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
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class  AppModule {
    @Singleton
    @Provides
    fun provideWeatherDao(application: Application): WeatherDao {
        var db = Room.databaseBuilder(
            application,
            AppDatabase::class.java, "weather"
        ).build()
        return db.weatherDao()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }



}