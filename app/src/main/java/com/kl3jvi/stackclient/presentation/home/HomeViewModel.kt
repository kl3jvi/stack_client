package com.kl3jvi.stackclient.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kl3jvi.stackclient.data.model.ItemDto
import com.kl3jvi.stackclient.domain.model.State
import com.kl3jvi.stackclient.domain.use_case.get_users.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    private val _users: MutableStateFlow<State<List<ItemDto>>> = MutableStateFlow(State.loading())
    val users: StateFlow<State<List<ItemDto>>> = _users

    fun getUsers() = viewModelScope.launch {
        getUsersUseCase().map { resource -> State.fromResource(resource) }
            .collect { state -> _users.value = state }
    }
}