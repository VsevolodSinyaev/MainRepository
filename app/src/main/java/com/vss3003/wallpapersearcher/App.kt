package com.vss3003.wallpapersearcher

import android.app.Application
import com.vss3003.wallpapersearcher.di.AppComponent
import com.vss3003.wallpapersearcher.di.DaggerAppComponent

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }

}