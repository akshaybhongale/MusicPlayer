package com.example.musicplayer.utils

import androidx.room.TypeConverter
import com.example.musicplayer.models.TopSongs
import com.google.gson.Gson

/**
 * This class is used to convert object for Room database
 */
class Converter {

    private val gson: Gson = Gson()

    @TypeConverter
    fun toString(result: TopSongs): String {
        return gson.toJson(result)
    }

    @TypeConverter
    fun fromString(dbResults: String): TopSongs {
        return gson.fromJson(dbResults, TopSongs::class.java)
    }

}