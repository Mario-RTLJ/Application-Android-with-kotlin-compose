package com.example.geteventproject

import android.app.Application
import androidx.room.Room
import com.example.geteventproject.data.local.database.EventDatabase

class MyApp : Application() {
    companion object {
        lateinit var database: EventDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            EventDatabase::class.java, "event-database"
        ).build()
    }
}
