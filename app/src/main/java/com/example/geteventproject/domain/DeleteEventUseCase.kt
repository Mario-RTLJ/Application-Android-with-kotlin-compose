package com.example.geteventproject.domain

import com.example.geteventproject.data.EventRepository
import com.example.geteventproject.data.local.database.EventEntity

class DeleteEventUseCase(private val eventRepository: EventRepository) {
    suspend operator fun invoke(event: EventEntity) {
        return eventRepository.deleteEvent(event)
    }
}