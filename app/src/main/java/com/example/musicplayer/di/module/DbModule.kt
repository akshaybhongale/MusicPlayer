package com.example.musicplayer.di.module

import android.content.Context
import androidx.room.Room
import com.example.musicplayer.db.DB_NAME
import com.example.musicplayer.db.Dao
import com.example.musicplayer.db.DbManager
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    fun providesDB(context: Context): DbManager {
        return Room.databaseBuilder(context, DbManager::class.java, DB_NAME)
            .build()
    }

    @Provides
    fun providesRoomDB(databaseManager: DbManager): Dao {
        return databaseManager.roomDAO()
    }
}