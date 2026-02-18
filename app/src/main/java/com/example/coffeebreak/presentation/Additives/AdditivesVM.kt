package com.example.coffeebreak.presentation.Additives

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreak.domain.repository.AdditivesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdditivesVM @Inject constructor(
    private val additivesRepository: AdditivesRepository
): ViewModel() {
    private val _state = mutableStateOf(AdditivesState())
    val state: State<AdditivesState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val additivesList = additivesRepository.getAdditivesList()
                _state.value = state.value.copy(
                    additivesList = additivesList,
                    load = false
                )
            } catch (ex: Exception) {
                Log.e("supa", ex.message.toString())
            }
        }
    }
}