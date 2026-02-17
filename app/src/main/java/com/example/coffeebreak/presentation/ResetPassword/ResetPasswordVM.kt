package com.example.coffeebreak.presentation.ResetPassword

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.coffeebreak.domain.usecase.IsPasswordValidUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetPasswordVM @Inject constructor(
    private val isPasswordValidUseCase: IsPasswordValidUseCase
): ViewModel() {
    private val _state = mutableStateOf(ResetPasswordState())
    val state: State<ResetPasswordState> = _state

    fun onEvent(event: ResetPasswordEvent){
        when(event){
            is ResetPasswordEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            ResetPasswordEvent.PasswordValid -> {
                val passwordValid = isPasswordValidUseCase.invoke(state.value.password)
                _state.value = state.value.copy(
                    passwordValid = passwordValid
                )
            }

            ResetPasswordEvent.ShowError -> {
                _state.value = state.value.copy(
                    error = !state.value.error
                )
            }
        }
    }
}