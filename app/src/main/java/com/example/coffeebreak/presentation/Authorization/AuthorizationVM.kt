package com.example.coffeebreak.presentation.Authorization

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreak.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationVM @Inject constructor(
    private val authUseCase: AuthUseCase
): ViewModel() {
    private val _state = mutableStateOf(AuthorizationState())
    val state: State<AuthorizationState> = _state

    fun onEvent(event: AuthorizationEvent){
        when(event){
            is AuthorizationEvent.EnteredEmail ->{
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is AuthorizationEvent.EnteredPassword ->{
                _state.value = state.value.copy(
                    password = event.value
                )
            }

            AuthorizationEvent.VisualTranform -> {
                _state.value = state.value.copy(
                    visual = !state.value.visual
                )
            }

            AuthorizationEvent.Auth -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        authUseCase.invoke(state.value.email,
                            state.value.password)
                        _state.value = state.value.copy(
                            isComplete = true
                        )
                    } catch (ex: Exception){
                        Log.e("supa", ex.message.toString())
                    }
                }
            }
        }
    }
}