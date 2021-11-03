package com.vss3003.wallpapersearcher.di.modules

import com.vss3003.wallpapersearcher.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideRepository() = MainRepository()
}