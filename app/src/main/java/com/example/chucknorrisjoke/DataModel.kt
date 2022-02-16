package com.example.chucknorrisjoke

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
    val text: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}