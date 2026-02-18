package com.example.coffeebreak.presentation.Profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileVM @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    fun onEvent(event: ProfileEvent){
        when(event){
            ProfileEvent.ShowQR -> {
                _state.value = state.value.copy(
                    qr = !state.value.qr
                )
            }
        }
    }
}