package com.kl3jvi.stackclient.domain.use_case.get_user

import com.kl3jvi.stackclient.data.model.ItemDto
import com.kl3jvi.stackclient.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(
    private val repository: UserRepository,
    private val ioDispatcher: CoroutineDispatcher
) {
    operator fun invoke(userId: Int): Flow<ItemDto> {
        return repository.getUserById(userId).flowOn(ioDispatcher)
    }
}