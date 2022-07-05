package com.example.musicplayer.models.topsongs

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HyperLinkAttributes(
    @SerializedName("title")
    val title: String?,
    @SerializedName("rel")
    val rel: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("href")
    val href: String?,
    @SerializedName("im:assetType")
    val imAssetType: String?,
) : Parcelable
