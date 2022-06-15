package com.example.mvvmlivedata.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmlivedata.model.City
import com.example.mvvmlivedata.model.CityDataProvider

class CityViewModel : ViewModel (){
    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var curentIndex = 0
    private val delay = 2000L

    init {
        loop()
    }

    fun getCityData() : LiveData<City> = cityData

    private fun loop(){
        Handler(Looper.getMainLooper()).postDelayed({ updateCity()}, delay)
    }

    private fun updateCity(){
        curentIndex ++
        curentIndex %= cities.size

        cityData.value = cities[curentIndex]

        loop()
    }

}