package com.example.musicplayer.models.topsongs

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Feed(
    @SerializedName("author")
    val author: Author?,
    @SerializedName("entry")
    val entry: List<Entry>?,
    @SerializedName("updated")
    val updated: Label?,
    @SerializedName("rights")
    val rights: Label?,
    @SerializedName("title")
    val title: Label?,
    @SerializedName("icon")
    val icon: Label?,
    @SerializedName("link")
    val link: List<HyperLinkAttributes>?,
    @SerializedName("id")
    val id: Label?,
) : Parcelable
