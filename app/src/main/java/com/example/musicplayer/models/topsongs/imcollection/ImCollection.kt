package com.example.musicplayer.models.topsongs.imcollection

import android.os.Parcelable
import com.example.musicplayer.models.topsongs.Label
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class ImCollection(
    @SerializedName("im:name")
    val imName: Label?,
    @SerializedName("link")
    val link: CollectionLink?,
    @SerializedName("im:contentType")
    val contentType: ImContentType?,
) : Parcelable
