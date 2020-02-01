package com.task.task

import android.os.Build
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode

@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
@Config(sdk =[Build.VERSION_CODES.O_MR1] ,manifest=Config.NONE)
class MainActivityRobolectricTest{
    private var activity: MainActivity? = null
    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()

    }



    @Test
    fun shouldNotBeNull(){
        assertNull(activity)
    }
    @Test
    fun shouldHaveTitle(){
        assertEquals(activity?.title.toString(),"Task")
    }


}
