package com.example.musicplayer.models.topsongs.imcollection

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImContentType(
    @SerializedName("im:contentType")
    val contentType: ContentType?,
    @SerializedName("attributes")
    val contentAttributes: ImContentAttributes?,
) : Parcelable
