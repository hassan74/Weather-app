package com.task.task.currentwheather.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.task.database.Weather
import com.task.task.currentwheather.domain.CurrentWeatherUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

enum class WeatherApiStatus { LOADING, ERROR, DONE }

class CurrentWeatherViewModel @Inject constructor(
    application: Application
):AndroidViewModel(application){
    @Inject
    lateinit var currentWeatherUseCase:CurrentWeatherUseCase

    var key ="48d0476191083383a0033fbd9272f451"
    private val parentJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob)
    private var _weatherLiveData= MutableLiveData<Weather>()
    private var _status= MutableLiveData<WeatherApiStatus>()
    private var _showSnackBarEvent= MutableLiveData<Boolean>()
    var weather: Weather?=null

    val weatherLiveData:LiveData<Weather>
        get() = _weatherLiveData
    val status:LiveData<WeatherApiStatus>
        get() = _status
    val showSnackBarEvent:LiveData<Boolean>
        get()= _showSnackBarEvent
    fun doneShowingSnackbar() {
        _showSnackBarEvent.value = null
    }
    fun saveWeather(){
        coroutineScope.launch {
            withContext(Dispatchers.IO){
                weatherLiveData.value?.let { weather ->currentWeatherUseCase.saveWeather(weather) }
            }
            _showSnackBarEvent.value=true
        }
    }

     fun getWeather(counteryId:String){
         coroutineScope.launch {
             var weathers =currentWeatherUseCase.getWeatherCoroutines(counteryId ,key)
             try {
                 _status.value= WeatherApiStatus.LOADING
                 //var result=getWeathers.await()
                 var result=weathers
                 _status.value= WeatherApiStatus.DONE
                 weather=result.main
                 weather?.countery=counteryId
                 weather?.date=System.currentTimeMillis()
                 _weatherLiveData.value=weather
             }catch (e:Exception){
                 _status.value= WeatherApiStatus.ERROR
                 TODO("handle error status - use interceptor")

             }
         }


    }
    fun getWeatherRxJava(counteryId:String){
        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            currentWeatherUseCase.getWeatherRxJava(counteryId ,key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.let{weathers->
                        _status.value= WeatherApiStatus.LOADING
                        //var result=getWeathers.await()
                        var result=weathers
                        _status.value= WeatherApiStatus.DONE
                        weather=result.main
                        weather?.countery=counteryId
                        weather?.date=System.currentTimeMillis()
                        _weatherLiveData.value=weather
                    }
                },{
                    _status.value= WeatherApiStatus.ERROR
                    TODO("handle error status /use interceptor")

                })
        )

    }
}