package com.money.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.concurrent.timer
import kotlin.math.log
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    lateinit var Text: TextView
    private var timerStateFlow = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Text = findViewById(R.id.text)

        timerStateFlow = ViewModelProvider(this)[MainViewModel::class.java]
        timerStateFlow.TimerStart()

            lifecycleScope.launchWhenStarted {
                timerStateFlow.TimerStateFlow.collect {
                    Text.text = it
                }
            }
    }
}