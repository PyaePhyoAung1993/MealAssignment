package com.azp.newsapp.api

import com.azp.newsapp.model1.Random
import com.azp.newsapp.model2.Categories
import com.azp.newsapp.model4.Region
import com.azp.newsapp.model5.Ingredient
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterfaceAll{

    @GET("random.php")
    fun getRandom() : Call<Random>

    @GET("categories.php")
    fun getCategories() : Call<Categories>

    @GET("list.php")
    fun getCountry(
    @Query("a") name : String
    )
    : Call<Region>

    @GET("list.php")
    fun getIngredient(
        @Query("i") name :String
    ) : Call<Ingredient>


}