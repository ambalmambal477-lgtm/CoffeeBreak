package com.example.coffeebreak.presentation.Designer

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DesignerVM @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(DesignerState())
    val state: State<DesignerState> = _state

    fun onEvent(event: DesignerEvent){
        when(event){
            DesignerEvent.ShowPanel -> {
                _state.value = state.value.copy(
                    panel = !state.value.panel
                )
            }
        }
    }
}