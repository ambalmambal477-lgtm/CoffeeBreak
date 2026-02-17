package com.example.coffeebreak.presentation.TwoFactorVerification

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TwoFactorVm @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(TwoFactorState())
    val state: State<TwoFactorState> = _state

    init {
        viewModelScope.launch {
            while (state.value.time > 0){
                delay(1000)
                _state.value = state.value.copy(
                    time =- 1
                )
            }
        }
    }

    fun onEvent(event: TwoFactorEvent){
        when(event){
            is TwoFactorEvent.EnteredFirstNumber -> {
                _state.value = state.value.copy(
                    firstNumber = event.value
                )
            }
            is TwoFactorEvent.EnteredFourthNumber -> {
                _state.value = state.value.copy(
                    fourthNumber = event.value
                )
            }
            is TwoFactorEvent.EnteredSecondNumber -> {
                _state.value = state.value.copy(
                    secondNumber = event.value
                )
            }
            is TwoFactorEvent.EnteredThirdNumber -> {
                _state.value = state.value.copy(
                    thirdNumber = event.value
                )
            }
        }
    }
}