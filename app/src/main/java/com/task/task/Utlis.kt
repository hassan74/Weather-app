package com.task.task

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import kotlin.math.round

fun Double.convertKelvinToCelsius(
): String {
    return (this-273.15).round(3).toString()+"°C"
}

@SuppressLint("SimpleDateFormat")
fun Long.convertLongToDateString(
): String {
    return SimpleDateFormat("EEEE MMM-dd-yyyy' Time: 'HH:mm")
        .format(this).toString()
}
fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}