package com.example.countercompose

import android.app.Application
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel

enum class Screen {
    COUNTER,
    DATA_DIRI
}

class CounterViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs = application.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val _counter = mutableIntStateOf(prefs.getInt(KEY_COUNTER, 0))
    val counter: State<Int> = _counter

    private val _currentScreen = mutableStateOf(Screen.COUNTER)
    val currentScreen: State<Screen> = _currentScreen

    fun increment() {
        updateCounter(_counter.intValue + 1)
    }

    fun decrement() {
        updateCounter(_counter.intValue - 1)
    }

    fun reset() {
        updateCounter(0)
    }

    fun navigateTo(screen: Screen) {
        _currentScreen.value = screen
    }

    private fun updateCounter(newValue: Int) {
        _counter.intValue = newValue
        prefs.edit { putInt(KEY_COUNTER, newValue) }
    }

    companion object {
        private const val PREFS_NAME = "counter_prefs"
        private const val KEY_COUNTER = "counter_value"
    }
}
