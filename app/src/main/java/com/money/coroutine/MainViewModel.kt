package com.money.coroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _timerStateFlow = MutableStateFlow<String>("")
    public val TimerStateFlow = _timerStateFlow

    public fun TimerStart() {
        val list = listOf<String>("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
        viewModelScope.launch {
            for (i in list) {
                _timerStateFlow.emit(i)
                delay(1000)
            }
        }

    }

}