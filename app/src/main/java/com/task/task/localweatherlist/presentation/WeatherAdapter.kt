package com.task.task.localweatherlist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.task.task.R
import com.task.task.convertKelvinToCelsius
import com.task.task.convertLongToDateString
import com.task.task.database.Weather

class WeatherAdapter(var weathers:ArrayList<Weather>) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
       return WeatherViewHolder(
           LayoutInflater.from(parent.context).inflate(
               R.layout.weather_item,
               parent,
               false
           )
       )

    }

    override fun getItemCount(): Int {
        return weathers.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.date.setText(weathers.get(position).date.convertLongToDateString())
        holder.temp.setText(weathers.get(position).temp.convertKelvinToCelsius())
        holder.itemView.setOnClickListener {
            var action =WeatherListFragmentDirections.actionLocalWeatherListFragmentToWeatherDetailsFragment(weathers.get(position))
            holder.itemView.findNavController()
                .navigate(action)
        }
    }
     class WeatherViewHolder( view: View) : RecyclerView.ViewHolder(view) {
        var date =view.findViewById<TextView>(R.id.tv_weather_item_date)
        var temp =view.findViewById<TextView>(R.id.tv_weather_item_temp)
    }
}