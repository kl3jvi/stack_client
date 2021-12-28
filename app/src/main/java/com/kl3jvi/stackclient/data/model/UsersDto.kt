package com.kl3jvi.stackclient.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UsersDto(
    @Json(name = "has_more")
    val hasMore: Boolean,
    @Json(name = "items")
    val items: List<ItemDto>,
    @Json(name = "quota_max")
    val quotaMax: Int,
    @Json(name = "quota_remaining")
    val quotaRemaining: Int
)