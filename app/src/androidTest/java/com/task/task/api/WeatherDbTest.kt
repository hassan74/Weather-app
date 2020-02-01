package com.task.task.api


import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.task.task.database.AppDatabase
import com.task.task.database.Weather
import com.task.task.database.WeatherDao
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class WeatherDbTest {
    @Inject
      private lateinit var weatherDao: WeatherDao
    private lateinit var db: AppDatabase
    @Before
    fun befor(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
    }
    @Test
    fun testInserAndGetFromtDataBase(){
        var weather=Weather(0,1.0,1.0,1.0,1,1,"",0)
            weatherDao.insertAll(weather)

        Assert.assertEquals(weather.pressure ,weatherDao.getAll().value?.get(0)?.pressure)
    }
    @After
    fun after(){
        db.close()

    }

}