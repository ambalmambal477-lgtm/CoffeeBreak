package com.example.coffeebreak.presentation.ForgotPassword

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.coffeebreak.domain.usecase.IsEmailValidUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordVM @Inject constructor(
    private val isEmailValidUseCase: IsEmailValidUseCase
): ViewModel() {
    private val _state = mutableStateOf(ForgotPasswordState())
    val state: State<ForgotPasswordState> = _state

    fun onEvent(event: ForgotPasswordEvent){
        when(event){
            is ForgotPasswordEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            ForgotPasswordEvent.IsEmailValid -> {
                val emailValid = isEmailValidUseCase.invoke(state.value.email)
                _state.value = state.value.copy(
                    emailValid = emailValid
                )
            }

            ForgotPasswordEvent.ShowError -> {
                _state.value = state.value.copy(
                    error = !state.value.error
                )
            }
        }
    }
}