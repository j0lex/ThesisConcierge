package com.example.thesisconcierge.ui.rateService

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RateServiceViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Please rate the service."
    }
    val text: LiveData<String> = _text
}
