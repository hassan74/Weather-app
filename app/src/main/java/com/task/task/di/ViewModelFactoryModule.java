package com.task.task.di;

import androidx.lifecycle.ViewModelProvider;


import com.task.task.currentwheather.presentation.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;


@Module
public abstract class ViewModelFactoryModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelFactory);

}
