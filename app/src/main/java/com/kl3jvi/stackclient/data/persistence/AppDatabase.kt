package com.kl3jvi.stackclient.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kl3jvi.stackclient.data.model.ItemDto

@Database(entities = [ItemDto::class], version = 1, exportSchema = false)
@TypeConverters(value = [BadgeConverter::class, CollectiveConverter::class, CollectivesConverter::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}