package com.task.task.di

import com.task.task.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
@ContributesAndroidInjector(modules = [FragmentsBuildersModule::class,ViewModelsModule::class])
    abstract fun contributeMainActivity(): MainActivity?

}