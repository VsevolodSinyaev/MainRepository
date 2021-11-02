package com.vss3003.wallpapersearcher

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(hApi: HApi) = Interactor(retrofitService = hApi)
}