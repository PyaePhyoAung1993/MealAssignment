package com.azp.newsapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azp.newsapp.api.CategoryApiClient
import com.azp.newsapp.api.MealApiClient
import com.azp.newsapp.model1.Random
import com.azp.newsapp.model2.Categories
import com.azp.newsapp.model2.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryViewmodel : ViewModel() {
    private var resultRandom: MutableLiveData<Categories> = MutableLiveData()

    fun getResultRandom(): LiveData<Categories> = resultRandom

    fun loadCategory() {
        var apiRandomClient = CategoryApiClient()
        var apiCallRandom = apiRandomClient.getCategory()

        apiCallRandom.enqueue(object : Callback<Categories> {
            override fun onFailure(call: Call<Categories>, t: Throwable) {

            }

            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                resultRandom.value = response.body()
            }

        })
    }
}