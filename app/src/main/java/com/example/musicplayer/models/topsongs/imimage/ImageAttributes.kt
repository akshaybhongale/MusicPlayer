package com.example.musicplayer.models.topsongs.imimage

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageAttributes(
    @SerializedName("height")
    val height: Int?,
) : Parcelable
