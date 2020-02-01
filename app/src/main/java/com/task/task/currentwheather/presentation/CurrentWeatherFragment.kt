package com.task.task.currentwheather.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.task.task.R
import com.task.task.convertKelvinToCelsius
import com.task.task.databinding.FragmentCurrentWeatherBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject
class CurrentWeatherFragment : DaggerFragment() {
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    var counteryId="London"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding : FragmentCurrentWeatherBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_current_weather, container, false)

        var currentWeatherViewModel:CurrentWeatherViewModel =
            ViewModelProviders.of(this  ,providerFactory).get(CurrentWeatherViewModel::class.java)
        currentWeatherViewModel.getWeather(counteryId)
        binding.citiesSpinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                binding.weatehrView.visibility=View.GONE
                binding.progressBar.visibility = View.VISIBLE
                currentWeatherViewModel.getWeatherRxJava(parent?.getItemAtPosition(position).toString())
            }

        }
        currentWeatherViewModel.weatherLiveData.observe(this , Observer{
            binding.tempTextview.setText(it?.temp?.convertKelvinToCelsius())
            binding.pressureTextview.setText(it?.pressure.toString())
            binding.humidityTextview.setText(it?.humidity.toString())
            binding.minTempTextview.setText(it?.tempMin?.convertKelvinToCelsius())
            binding.maxTempTextview.setText(it?.tempMax?.convertKelvinToCelsius())

        } )
        currentWeatherViewModel.status.observe(this , Observer {status->
            when (status) {
                WeatherApiStatus.LOADING -> {
                    binding.weatehrView.visibility=View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                }
                WeatherApiStatus.ERROR -> {
                    binding.weatehrView.visibility=View.GONE
                    binding.progressBar.visibility = View.GONE
                }
                WeatherApiStatus.DONE -> {
                    binding.weatehrView.visibility=View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                }
            }})
        binding.saveButton.setOnClickListener {
            currentWeatherViewModel.saveWeather()
        }
        currentWeatherViewModel.showSnackBarEvent.observe(this, Observer {
            it?.let {
                if (it) {
                    Snackbar.make(
                        activity!!.findViewById(android.R.id.content),
                        getString(R.string.weather_saved),
                        Snackbar.LENGTH_SHORT
                    ).show()
                    currentWeatherViewModel.doneShowingSnackbar()
                }
            }

        })

        return binding.root

    }
}