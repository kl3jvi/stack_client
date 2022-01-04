package com.kl3jvi.stackclient.data.model


import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@JsonClass(generateAdapter = true)
@Parcelize
@Entity
data class ItemDto(
    @field:Json(name = "accept_rate")
    val acceptRate: Int?,
    @field:Json(name = "account_id")
    @PrimaryKey
    val accountId: Int?,
    @field:Json(name = "badge_counts")
    val badgeCounts: BadgeCountsDto?,
    @field:Json(name = "collectives")
    val collectives: List<CollectivesDto>?,
    @field:Json(name = "creation_date")
    val creationDate: Int?,
    @field:Json(name = "display_name")
    val displayName: String?,
    @field:Json(name = "is_employee")
    val isEmployee: Boolean?,
    @field:Json(name = "last_access_date")
    val lastAccessDate: Int?,
    @field:Json(name = "last_modified_date")
    val lastModifiedDate: Int?,
    @field:Json(name = "link")
    val link: String?,
    @field:Json(name = "location")
    val location: String?,
    @field:Json(name = "profile_image")
    val profileImage: String?,
    @field:Json(name = "reputation")
    val reputation: Int?,
    @field:Json(name = "reputation_change_day")
    val reputationChangeDay: Int?,
    @field:Json(name = "reputation_change_month")
    val reputationChangeMonth: Int?,
    @field:Json(name = "reputation_change_quarter")
    val reputationChangeQuarter: Int?,
    @field:Json(name = "reputation_change_week")
    val reputationChangeWeek: Int?,
    @field:Json(name = "reputation_change_year")
    val reputationChangeYear: Int?,
    @field:Json(name = "user_id")
    val userId: Int?,
    @field:Json(name = "user_type")
    val userType: String?,
    @field:Json(name = "website_url")
    val websiteUrl: String?
) : Parcelable {
    @SuppressLint("SimpleDateFormat")
    fun getDateTime(): String? {
        return try {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val netDate = Date(creationDate?.toLong()?.times(1000) ?: 0)
            sdf.format(netDate)
        } catch (e: Exception) {
            e.toString()
        }
    }
}

