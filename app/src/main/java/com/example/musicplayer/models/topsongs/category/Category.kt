package com.example.musicplayer.models.topsongs.category

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    @SerializedName("attributes")
    val attributes: CategoryAttributes?,
) : Parcelable
