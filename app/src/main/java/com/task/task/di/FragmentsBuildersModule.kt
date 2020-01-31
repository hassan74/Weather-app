package com.task.task.di

import com.task.task.localweatherlist.presentation.WeatherListFragment
import com.task.task.currentwheather.presentation.CurrentWeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsBuildersModule {
@ContributesAndroidInjector(
    )
    abstract fun contributeCurrentFragment(): CurrentWeatherFragment

    @ContributesAndroidInjector()
    abstract fun contributeWeatherListFragment(): WeatherListFragment

}