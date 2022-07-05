package com.example.musicplayer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.musicplayer.db.tables.DBSongsList
import com.example.musicplayer.utils.Converter


@Database(
    entities =
    [DBSongsList::class],
    version = DB_VERSION
)
@TypeConverters(Converter::class)
abstract class DbManager : RoomDatabase() {
    abstract fun roomDAO(): Dao
}