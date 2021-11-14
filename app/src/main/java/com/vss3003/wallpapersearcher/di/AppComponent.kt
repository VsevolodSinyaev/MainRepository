package com.vss3003.wallpapersearcher.di

import com.vss3003.wallpapersearcher.di.modules.DomainModule
import com.vss3003.wallpapersearcher.di.modules.RemoteModule
import com.vss3003.wallpapersearcher.viewmodel.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            RemoteModule::class,
            DomainModule::class
        ]
)
interface AppComponent {
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
}