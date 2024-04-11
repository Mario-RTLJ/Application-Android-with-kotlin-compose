package com.example.geteventproject.data.repository

import com.example.geteventproject.data.EventRepository
import com.example.geteventproject.data.local.EventDao
import com.example.geteventproject.data.local.database.EventEntity
import kotlinx.coroutines.flow.Flow

class EventRepositoryImpl(private val eventDao: EventDao) : EventRepository {
    override suspend fun getAllEvents(): Flow<List<EventEntity>> {
        return eventDao.getAllEventsFlow()
    }

    override suspend fun addEvent(event: EventEntity) {
        eventDao.addEvent(event)
    }

    override suspend fun updateEvent(event: EventEntity) {
        eventDao.updateEvent(event)
    }

    override suspend fun deleteEvent(event: EventEntity) {
        eventDao.deleteEvent(event)
    }
}