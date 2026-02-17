package com.example.coffeebreak.presentation.Registartion

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreak.domain.model.User
import com.example.coffeebreak.domain.usecase.RegistrationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class RegistrationVM @Inject constructor(
    private val registrationUseCase: RegistrationUseCase
): ViewModel() {
    private val _state = mutableStateOf(RegistrationState())
    val state: State<RegistrationState> = _state

    fun onEvent(event: RegistrationEvent){
        when(event){
            RegistrationEvent.ChangeVisual -> {
                _state.value = state.value.copy(
                    visual = !state.value.visual
                )
            }
            is RegistrationEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is RegistrationEvent.EnteredName -> {
                _state.value = state.value.copy(
                    name = event.value
                )
            }
            is RegistrationEvent.EnteredNumber -> {
                _state.value = state.value.copy(
                    number = event.value
                )
            }
            is RegistrationEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }

            RegistrationEvent.Checked -> {
                _state.value = state.value.copy(
                    checked = !state.value.checked
                )
            }

            RegistrationEvent.Registration -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        if(state.value.checked) {
                            registrationUseCase.invoke(
                                state.value.email,
                                state.value.password
                            )
                            _state.value = state.value.copy(
                                isComplete = true
                            )
                        }
                    } catch (ex: Exception){
                        Log.e("supa", ex.message.toString())
                    }
                }
            }
        }
    }
}