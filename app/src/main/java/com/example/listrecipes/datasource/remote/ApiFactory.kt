package com.example.listrecipes.datasource.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://api.spoonacular.com/recipes/"

    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    var recipeService = retrofit.create(RecipeService::class.java)
}