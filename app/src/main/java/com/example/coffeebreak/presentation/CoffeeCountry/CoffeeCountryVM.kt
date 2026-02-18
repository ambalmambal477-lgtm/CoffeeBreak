package com.example.coffeebreak.presentation.CoffeeCountry

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreak.domain.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeCountryVM @Inject constructor(
    private val countryRepository: CountryRepository
) : ViewModel() {
    private val _state = mutableStateOf(CoffeeCountryState())
    val state: State<CoffeeCountryState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val countryList = countryRepository.getCountryList()
                _state.value = state.value.copy(
                    coffeeCountryList = countryList,
                    load = false
                )
            } catch (ex: Exception) {
                Log.e("supa", ex.message.toString())
            }
        }
    }
}