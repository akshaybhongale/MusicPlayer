package com.example.musicplayer.models.topsongs.imreleasedate

import android.os.Parcelable
import com.example.musicplayer.models.topsongs.Label
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImReleaseDate(
    @SerializedName("label")
    val label: String?,
    @SerializedName("attributes")
    val attributes: Label?,
) : Parcelable
