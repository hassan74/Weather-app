package com.task.task.localweatherlist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.task.R
import com.task.task.database.Weather
import com.task.task.databinding.FragmentWeatherListBinding
import com.task.task.currentwheather.presentation.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class WeatherListFragment : DaggerFragment() {

    private  var weathers=ArrayList<Weather>()
    lateinit var viewModel: WeatherViewModel
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding :FragmentWeatherListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_weather_list, container, false)
        val application = requireNotNull(this.activity).application
        viewModel = ViewModelProviders.of(this  ,providerFactory).get(
            WeatherViewModel::class.java)
        binding.rvWeather.layoutManager= LinearLayoutManager(application)
        binding.rvWeather.adapter=
            WeatherAdapter(weathers)
        viewModel.weatherLiveData.observe(this , Observer {weatherList ->
            weatherList?.let{
                weathers.clear()
                weathers.addAll(weatherList)
                binding.rvWeather.adapter?.notifyDataSetChanged()
            }
        })

        binding.navigateButton.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_localWeatherListFragment_to_remoteWeatherFragment)
        }
        return binding.root
    }

}