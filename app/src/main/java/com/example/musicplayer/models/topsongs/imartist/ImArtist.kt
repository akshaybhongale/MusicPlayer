package com.example.musicplayer.models.topsongs.imartist

import android.os.Parcelable
import com.example.musicplayer.models.topsongs.HyperLinkAttributes
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImArtist(
    @SerializedName("label")
    val label: String?,
    @SerializedName("attributes")
    val attributes: HyperLinkAttributes?,
) : Parcelable
