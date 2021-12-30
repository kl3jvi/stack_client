package com.kl3jvi.stackclient.domain.use_case.get_users

import com.kl3jvi.stackclient.common.Resource
import com.kl3jvi.stackclient.data.model.ItemDto
import com.kl3jvi.stackclient.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository,
    private val ioDispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<Resource<List<ItemDto>>> {
        return repository.getAllUsers().flowOn(ioDispatcher)
    }
}