package com.example.musicplayer.models

import android.os.Parcelable
import com.example.musicplayer.models.topsongs.Feed
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TopSongs(
    @SerializedName("feed")
    val feed: Feed,
) : Parcelable
