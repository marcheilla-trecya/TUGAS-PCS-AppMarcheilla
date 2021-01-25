package com.marcheilla.appmarcheilla.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News (
    val title: String = "",
    val url: String = "",
    val urlToImage: String = "",
    val author: String = "",
    val publishedAt: String = ""
) : Parcelable