package com.example.musicplayer.repo


import com.example.musicplayer.api.IApi
import com.example.musicplayer.db.Dao
import com.example.musicplayer.db.tables.DBSongsList
import com.example.musicplayer.models.TopSongs
import javax.inject.Inject

/**
 * This class is used to provide access to REST API and room database
 */
class Repos @Inject constructor(val api: IApi, val dao: Dao) {

    suspend fun getTopSongs(
    ): TopSongs {
        return api.getTopSongs()
    }

    suspend fun saveIntoDB(topSongs: TopSongs) {
        val dbList = DBSongsList(topSongs)
        dao.insert(dbList)
    }

    suspend fun getSongListFromDB(): DBSongsList? {
        return dao.getTopSongsList()
    }


}