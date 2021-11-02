package com.vss3003.wallpapersearcher.di

import com.vss3003.wallpapersearcher.viewmodel.HeroViewModel
import com.vss3003.wallpapersearcher.di.modules.DomainModule
import com.vss3003.wallpapersearcher.di.modules.RemoteModule
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
    fun inject(heroViewModel: HeroViewModel)
}