package com.example.musicplayer.models.topsongs.imprice

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImPrice(
    @SerializedName("label")
    val label: String?,
    @SerializedName("attributes")
    val attributes: PriceAttributes?,
) : Parcelable
