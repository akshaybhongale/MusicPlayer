package com.example.musicplayer.models.topsongs

import android.os.Parcelable
import com.example.musicplayer.models.topsongs.category.Category
import com.example.musicplayer.models.topsongs.imartist.ImArtist
import com.example.musicplayer.models.topsongs.imcollection.ImCollection
import com.example.musicplayer.models.topsongs.imcollection.ImContentType
import com.example.musicplayer.models.topsongs.imid.Id
import com.example.musicplayer.models.topsongs.imimage.ImImage
import com.example.musicplayer.models.topsongs.imprice.ImPrice
import com.example.musicplayer.models.topsongs.imreleasedate.ImReleaseDate
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Entry(
    @SerializedName("im:name")
    val imName: Label?,
    @SerializedName("im:image")
    val imAttributes: List<ImImage>?,
    @SerializedName("im:collection")
    val imCollection: ImCollection?,
    @SerializedName("im:price")
    val imPrice: ImPrice?,
    @SerializedName("im:contentType")
    val imContentType: ImContentType?,
    @SerializedName("rights")
    val rights: Label?,
    @SerializedName("title")
    val title: Label?,
    @SerializedName("link")
    val link: List<Link>?,
    @SerializedName("id")
    val id: Id?,
    @SerializedName("im:artist")
    val imArtist: ImArtist?,
    @SerializedName("category")
    val category: Category?,
    @SerializedName("im:release")
    val imRelease: ImReleaseDate?,
) : Parcelable
