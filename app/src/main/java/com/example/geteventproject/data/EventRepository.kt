package com.example.geteventproject.data

import com.example.geteventproject.data.local.database.EventEntity
import kotlinx.coroutines.flow.Flow

interface EventRepository {
    suspend fun getAllEvents(): Flow<List<EventEntity>>
    suspend fun addEvent(event: EventEntity)
    suspend fun updateEvent(event: EventEntity)
    suspend fun deleteEvent(event: EventEntity)
}