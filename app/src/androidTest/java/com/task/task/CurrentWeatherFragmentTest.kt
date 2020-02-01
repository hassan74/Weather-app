package com.task.task

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.task.task.currentwheather.presentation.CurrentWeatherFragment
import com.task.task.weatherdetails.WeatherDetailsFragment
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class CurrentWeatherFragmentTest     {
    @Test
    fun launchFragmentAndVerifyUI() {
        //it crash because daggerfragment
        launchFragmentInContainer<CurrentWeatherFragment>()
        onView(withId(R.id.temp_title_textview)).check(matches(withText("Temp:")));
    }
    @Test fun testEventFragment() {
         var scenario =launchFragmentInContainer<WeatherDetailsFragment>()
        onView(withId(R.id.temp_title_textview)).check(matches(withText("Temp:")))
    }


}