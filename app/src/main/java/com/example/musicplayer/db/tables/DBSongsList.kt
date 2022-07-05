package com.example.musicplayer.db.tables

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicplayer.models.TopSongs

@Entity
data class DBSongsList(
    var results: TopSongs?,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}