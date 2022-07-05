package com.example.musicplayer

import android.app.Application
import com.example.musicplayer.di.component.AppComponent
import com.example.musicplayer.di.component.DaggerAppComponent

open class App : Application() {

    /**
     * DI graph instance for appComponent
     */
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }

}