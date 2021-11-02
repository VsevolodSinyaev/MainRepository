package com.vss3003.wallpapersearcher.di.modules

import com.vss3003.wallpapersearcher.domain.Interactor
import com.vss3003.wallpapersearcher.data.HApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(hApi: HApi) = Interactor(retrofitService = hApi)
}