package com.example.musicplayer.models.topsongs.imcollection

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImContentAttributes(
    @SerializedName("term")
    val term: String?,
    @SerializedName("label")
    val label: String?,
) : Parcelable
