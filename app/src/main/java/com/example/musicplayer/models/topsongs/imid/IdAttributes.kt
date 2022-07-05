package com.example.musicplayer.models.topsongs.imid

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class IdAttributes(
    @SerializedName("im:id")
    val imId: String?,
) : Parcelable
