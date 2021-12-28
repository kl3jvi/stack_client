package com.kl3jvi.stackclient.data.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class CollectiveDto(
    @Json(name = "description")
    val description: String,
    @Json(name = "external_links")
    val externalLinks: List<ExternalLinkDto>,
    @Json(name = "link")
    val link: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "tags")
    val tags: List<String>
): Parcelable