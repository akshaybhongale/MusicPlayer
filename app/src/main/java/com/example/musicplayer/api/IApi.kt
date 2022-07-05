package com.example.musicplayer.api

import com.example.musicplayer.models.TopSongs
import retrofit2.http.GET

/**
 * Interface for consuming REST Api
 */
interface IApi {

    /**
     * This method is used to execute REST API call to top songs
     * @return Songs feed response from Server
     */
    @GET(TOP_SONGS)
    suspend fun getTopSongs(
    ): TopSongs


}