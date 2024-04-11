package com.example.geteventproject.domain

import com.example.geteventproject.data.EventRepository
import com.example.geteventproject.data.local.database.EventEntity

class AddEventUseCase(private val eventRepository: EventRepository) {
    suspend operator fun invoke(event: EventEntity) {
        return eventRepository.addEvent(event)
    }
}