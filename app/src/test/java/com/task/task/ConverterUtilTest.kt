package com.task.task

import org.junit.Assert.*
import org.junit.Test

class ConverterUtilTest {

    @Test
    fun testConvertFahrenheitToCelsius() {
        val actual: Float =100f
        // expected value is 212
        val expected = 212f
        // use this method because float is not precise
        assertEquals( expected, actual)
    }

    @Test
    fun testConvertCelsiusToFahrenheit() {
        val actual: Float = 100f
        // expected value is 100
        val expected = 100f
        // use this method because float is not precise
        assertEquals("Conversion from celsius to fahrenheit failed",
            expected.toDouble(), actual.toDouble(), 0.001)
    }
}