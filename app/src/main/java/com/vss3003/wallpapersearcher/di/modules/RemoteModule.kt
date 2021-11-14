package com.vss3003.wallpapersearcher.di.modules

import com.vss3003.wallpapersearcher.BuildConfig
import com.vss3003.wallpapersearcher.data.ApiConstants
import com.vss3003.wallpapersearcher.data.HApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RemoteModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
            //Настраиваем таймауты для медленного интернета
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            //Добавляем логгер
            .addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BASIC
                }
            })
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            //Указываем базовый URL из констант
            .baseUrl(ApiConstants.BASE_URL)
            //Добавляем конвертер
            .addConverterFactory(GsonConverterFactory.create())
            //Добавляем кастомный клиент
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideHeroApi(retrofit: Retrofit): HApi = retrofit.create(HApi::class.java)
}