package com.example.musicplayer.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.musicplayer.db.tables.DBSongsList

@Dao
interface Dao {

    @Query("Select * from DBSongsList")
    suspend fun getTopSongsList(): DBSongsList

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(list: DBSongsList)

}