package com.example.recipes.datasource.remote

import com.example.recipes.domain.Recipe
import retrofit2.http.GET
import retrofit2.http.Query


//хранит методы по работе с сетью
interface RecipeService {

    @GET("complexSearch")
    fun getAllRecipesForType(
        @Query("type") type: String,
        @Query("number") number: Int =100,
        @Query("apiKey") apiKey: String = "de7bf41978a04f17bd0f0e4859d9fee0"
    ): List<Recipe>

    @GET("complexSearch")
    fun getRecipesForSearch(
        @Query("query") query: String,
        @Query("number") number: Int =100,
        @Query("apiKey") apiKey: String = "de7bf41978a04f17bd0f0e4859d9fee0"
    ): List<Recipe>

    @GET("complexSearch")
    fun getAllRecipes(
        @Query("number") number: Int =100,
        @Query("apiKey") apiKey: String = "de7bf41978a04f17bd0f0e4859d9fee0"
    ): List<Recipe>
}