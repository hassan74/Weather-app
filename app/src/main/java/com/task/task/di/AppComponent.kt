package com.task.task.di

import android.app.Application
import com.task.task.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

//
//@Singleton
//@Component(
//    modules = [
//       AndroidSupportInjectionModule::class,
//        AppModule::class
//      //  RemoteWeatherModule::class,
//       // ActivityBuildersModule::class
//    ]
//)
@Component(
    modules = [
       AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuildersModule::class,
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