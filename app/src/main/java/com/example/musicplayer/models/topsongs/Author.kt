package com.example.musicplayer.models.topsongs

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Author(
    @SerializedName("name")
    val name: Label?,
    @SerializedName("uri")
    val uri: Label?,
) : Parcelable
