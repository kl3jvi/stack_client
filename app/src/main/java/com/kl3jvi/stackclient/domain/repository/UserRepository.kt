package com.kl3jvi.stackclient.domain.repository

import com.kl3jvi.stackclient.data.model.ItemDto
import com.kl3jvi.stackclient.common.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAllUsers(): Flow<Resource<List<ItemDto>>>
    fun getUserById(userId: Int): Flow<ItemDto>
}

