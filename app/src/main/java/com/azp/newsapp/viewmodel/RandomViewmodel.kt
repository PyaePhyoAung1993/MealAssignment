package com.azp.newsapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azp.newsapp.api.CategoryApiClient
import com.azp.newsapp.api.MealApiClient
import com.azp.newsapp.model1.Meal
import com.azp.newsapp.model1.Random
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RandomViewModel : ViewModel() {
    private var resultRandom: MutableLiveData<Random> = MutableLiveData()

    fun getResultRandom(): LiveData<Random> = resultRandom

    fun loadRandom() {
        var apiRandomClient = MealApiClient()
        var apiCallRandom = apiRandomClient.getRandom()

        apiCallRandom.enqueue(object : Callback<Random> {
            override fun onFailure(call: Call<Random>, t: Throwable) {

            }

            override fun onResponse(call: Call<Random>, response: Response<Random>) {
                resultRandom.value = response.body()
            }

        })
    }
}