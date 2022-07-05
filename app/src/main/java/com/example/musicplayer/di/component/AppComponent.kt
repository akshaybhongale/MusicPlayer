package com.example.musicplayer.di.component

import android.content.Context
import com.example.musicplayer.di.module.ApiModule
import com.example.musicplayer.di.module.DbModule
import com.example.musicplayer.di.module.ViewModelModule
import com.example.musicplayer.ui.activities.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ApiModule::class, ViewModelModule::class, DbModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
        ): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}