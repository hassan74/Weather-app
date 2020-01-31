package com.task.task.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather")
    fun getAll():LiveData<List<Weather>>

    @Query("SELECT * FROM weather WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Weather>

    @Query("SELECT * FROM weather WHERE countery LIKE :countery  LIMIT 1")
    fun findByCountery(countery: String ): Weather

    @Insert
    fun insertAll(vararg weather: Weather)

    @Delete
    fun delete(user: Weather)
}