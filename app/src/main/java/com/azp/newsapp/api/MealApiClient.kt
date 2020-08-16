package com.azp.newsapp.api


import com.azp.newsapp.model1.Random
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealApiClient {
    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    var retrofit: Retrofit? = null

    val apiInterfaceAll : ApiInterfaceAll
    init {
        var retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        apiInterfaceAll = retrofit.create(ApiInterfaceAll::class.java)
    }

    fun getRandom(): Call<Random> {
        return apiInterfaceAll.getRandom()
    }
}