package com.kl3jvi.stackclient.data.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class ExternalLinkDto(
    @Json(name = "link")
    val link: String,
    @Json(name = "type")
    val type: String
):Parcelable