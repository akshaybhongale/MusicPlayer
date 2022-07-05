package com.example.musicplayer.models.topsongs.imprice

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PriceAttributes(
    @SerializedName("amount")
    val amount: String?,
    @SerializedName("currency")
    val currency: String?,
) : Parcelable
