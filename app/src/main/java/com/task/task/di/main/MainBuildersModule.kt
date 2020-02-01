package com.task.task.di.main

import com.task.task.MainActivity
import com.task.task.di.ViewModelsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainBuildersModule {
    @MainScope
    @ContributesAndroidInjector(modules = [FragmentsBuildersModule::class, ViewModelsModule::class, MainModule::class] )
    abstract fun contributeMainActivity(): MainActivity?

}