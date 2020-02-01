package com.task.task.weatherdetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.task.task.R
import com.task.task.convertKelvinToCelsius
import com.task.task.convertLongToDateString
import com.task.task.database.Weather
import com.task.task.databinding.FragmentWeatherDetailsBinding
class WeatherDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding : FragmentWeatherDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_weather_details, container, false)
        var weather: Weather? = arguments?.get("weathertKey") as Weather?
        weather?.let{
            binding.titleTextview.setText(it.countery)
            binding.tempTextview.setText(it.temp.convertKelvinToCelsius())
            binding.pressureTextview.setText(it.pressure.toString())
            binding.humidityTextview.setText(it.humidity.toString())
            binding.minTempTextview.setText(it.tempMin.convertKelvinToCelsius())
            binding.maxTempTextview.setText(it.tempMax.convertKelvinToCelsius())
            binding.dateTextview.setText(it.date.convertLongToDateString())
        }

        return binding.root

    }
}