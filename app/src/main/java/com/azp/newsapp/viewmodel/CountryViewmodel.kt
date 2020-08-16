package com.azp.newsapp.viewmodel

import com.azp.newsapp.api.CountryApiClient
import com.azp.newsapp.model4.Region
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryViewmodel : ViewModel() {
    private var resultRandom: MutableLiveData<Region> = MutableLiveData()

    fun getResultRandom(): LiveData<Region> = resultRandom

    fun loadCountry() {
        var apiRandomClient = CountryApiClient()
        var apiCallRandom = apiRandomClient.getCountry("list")

        apiCallRandom.enqueue(object : Callback<Region> {
            override fun onFailure(call: Call<Region>, t: Throwable) {

            }

            override fun onResponse(call: Call<Region>, response: Response<Region>) {
                resultRandom.value = response.body()
            }

        })
    }
}