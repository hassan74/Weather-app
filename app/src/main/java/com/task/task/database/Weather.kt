package com.task.task.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity
data class Weather(

    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "temp") var temp: Double,
    @ColumnInfo(name = "temp_min")@SerializedName("temp_min") var tempMin: Double,
    @ColumnInfo(name = "temp_max")@SerializedName("temp_max") var tempMax: Double,
    @ColumnInfo(name = "pressure")var pressure: Int,
    @ColumnInfo(name = "humidity")var humidity: Int ,
    @ColumnInfo(name = "countery")var countery:String?,
    @ColumnInfo(name = "date")var date:Long=System.currentTimeMillis()

):Serializable