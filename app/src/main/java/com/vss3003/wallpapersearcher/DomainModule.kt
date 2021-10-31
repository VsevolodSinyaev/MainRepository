package com.vss3003.wallpapersearcher

import Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, cApi: CApi) = Interactor(repo = repository, retrofitService = cApi)
}