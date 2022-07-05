package com.example.musicplayer.models.topsongs.imimage

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImImage(
    @SerializedName("label")
    val label: String?,
    @SerializedName("attributes")
    val attributes: ImageAttributes?,
) : Parcelable
