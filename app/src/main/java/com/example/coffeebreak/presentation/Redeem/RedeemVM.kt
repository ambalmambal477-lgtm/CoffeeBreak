package com.example.coffeebreak.presentation.Redeem

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreak.domain.repository.RedeemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RedeemVM @Inject constructor(
    private val redeemRepository: RedeemRepository
): ViewModel() {
    private val _state = mutableStateOf(RedeemState())
    val state: State<RedeemState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val redeemList = redeemRepository.getRedeemList()
                _state.value = state.value.copy(
                    redeemList = redeemList,
                    load = false
                )
            } catch (ex: Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }
}