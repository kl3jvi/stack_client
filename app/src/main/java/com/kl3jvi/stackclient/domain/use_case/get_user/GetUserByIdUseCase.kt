package com.kl3jvi.stackclient.domain.use_case.get_user

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.kl3jvi.stackclient.data.model.ItemDto
import com.kl3jvi.stackclient.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(
    private val repository: UserRepository,
    private val ioDispatcher: CoroutineDispatcher
) {
    operator fun invoke(userId: Int): LiveData<ItemDto> {
        return repository.getUserById(userId).asLiveData(ioDispatcher)
    }
}