package com.money.coroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _timerStateFlow = MutableStateFlow<Int>(0)
    public val TimerStateFlow = _timerStateFlow

    public fun TimerStart() {

        viewModelScope.launch {
            for (i in 1..10) {
                _timerStateFlow.emit(i)
                delay(1000)
            }
        }

    }

}