package com.task.task.di

import android.app.Application
import com.task.task.BaseApplication
import com.task.task.di.main.MainBuildersModule
import com.task.task.di.main.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
       AndroidSupportInjectionModule::class,
        AppModule::class,
        MainBuildersModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent

    }
}