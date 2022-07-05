package com.example.musicplayer.models.topsongs.imcollection

import android.os.Parcelable
import com.example.musicplayer.models.topsongs.HyperLinkAttributes
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CollectionLink(
    @SerializedName("attributes")
    val attributes: HyperLinkAttributes?,
) : Parcelable
