package com.kl3jvi.stackclient.data.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kl3jvi.stackclient.common.Constants.TABLE_NAME
import com.kl3jvi.stackclient.data.model.ItemDto
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {

    /**
     * Inserts [users] into the [TABLE_NAME] table.
     * Duplicate values are replaced in the table.
     * @param users Posts
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUsers(users: List<ItemDto>)

    /**
     * Deletes all the users from the [Post.TABLE_NAME] table.
     */
    @Query("DELETE FROM ItemDto")
    suspend fun deleteAllUsers()

    /**
     * Fetches the post from the [TABLE_NAME] table whose id is [userId].
     * @param userId Unique ID of [ItemDto]
     * @return [Flow] of [ItemDto] from database table.
     */
    @Query("SELECT * FROM ItemDto WHERE accountId = :userId")
    fun getUserById(userId: Int): Flow<ItemDto>

    /**
     * Fetches all the users from the [TABLE_NAME] table.
     * @return [Flow]
     */
    @Query("SELECT * FROM ItemDto")
    fun getAllUsers(): Flow<List<ItemDto>>
}
