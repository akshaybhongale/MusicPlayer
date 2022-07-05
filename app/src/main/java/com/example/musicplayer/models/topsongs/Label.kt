package com.example.musicplayer.models.topsongs

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Label(
    @SerializedName("label")
    val label: String?,
) : Parcelable
