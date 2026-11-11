package com.example.countercompose

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DataDiriViewModel : ViewModel() {
    private val _nama = mutableStateOf("")
    val nama: State<String> = _nama

    private val _umur = mutableStateOf("")
    val umur: State<String> = _umur

    fun updateNama(newNama: String) {
        _nama.value = newNama
    }

    fun updateUmur(newUmur: String) {
        _umur.value = newUmur
    }
}
