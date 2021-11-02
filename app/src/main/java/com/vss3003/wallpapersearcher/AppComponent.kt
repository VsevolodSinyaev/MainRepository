package com.vss3003.wallpapersearcher

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