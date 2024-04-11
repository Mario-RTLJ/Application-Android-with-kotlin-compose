package com.example.geteventproject.presentation.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geteventproject.data.local.database.EventEntity
import com.example.geteventproject.domain.GetEventsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EventViewModel(private val getEventsUseCase: GetEventsUseCase) : ViewModel() {
    private val _events = MutableStateFlow<List<EventEntity>>(emptyList())
    val events = _events.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        fetchEvents()
    }

    private fun fetchEvents() {
        viewModelScope.launch {
            getEventsUseCase().collect { eventsList ->
                _events.value = eventsList
                _isLoading.value = false
            }
        }
    }
}
