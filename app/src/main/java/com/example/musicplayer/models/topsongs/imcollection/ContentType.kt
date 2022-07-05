package com.example.musicplayer.models.topsongs.imcollection

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContentType(
    @SerializedName("attributes")
    val attributes: ImContentAttributes?,
) : Parcelable
