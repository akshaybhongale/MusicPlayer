package com.example.musicplayer.models.topsongs.category

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryAttributes(
    @SerializedName("im:id")
    val id: String?,
    @SerializedName("term")
    val term: String?,
    @SerializedName("scheme")
    val scheme: String?,
    @SerializedName("label")
    val label: String?,
) : Parcelable
