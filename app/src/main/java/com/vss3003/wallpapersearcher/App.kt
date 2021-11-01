package com.vss3003.wallpapersearcher

import Interactor
import android.app.Application
import javax.inject.Inject

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

    @Inject
    lateinit var interactor: Interactor
}