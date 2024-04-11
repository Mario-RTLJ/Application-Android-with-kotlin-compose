package com.example.geteventproject.domain

import com.example.geteventproject.data.EventRepository
import com.example.geteventproject.data.local.database.EventEntity
import kotlinx.coroutines.flow.Flow

class GetEventsUseCase(private val eventRepository: EventRepository) {
    suspend operator fun invoke(): Flow<List<EventEntity>> {
        return eventRepository.getAllEvents()
    }
}