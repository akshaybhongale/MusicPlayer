package com.example.musicplayer.models.topsongs

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Link(
    @SerializedName("im:duration")
    val imDuration: Label?,
    @SerializedName("attributes")
    val attributes: HyperLinkAttributes?,
) : Parcelable
