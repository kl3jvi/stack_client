package com.kl3jvi.stackclient.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kl3jvi.stackclient.domain.use_case.get_user.GetUserByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * No need for this view model as the api works fine without making another request
 * anyway I have build the methods and the classess for different approach
 */

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}