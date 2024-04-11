package com.example.geteventproject.presentation.add_event

import AddEventViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.geteventproject.domain.AddEventUseCase

class AddEventViewModelFactory(private val addEventUseCase: AddEventUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddEventViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddEventViewModel(addEventUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

