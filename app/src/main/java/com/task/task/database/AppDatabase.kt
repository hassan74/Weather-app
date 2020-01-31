package com.task.task.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Weather::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}