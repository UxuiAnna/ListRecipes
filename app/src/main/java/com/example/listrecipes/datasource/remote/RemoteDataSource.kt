package com.example.listrecipes.datasource.remote

import com.example.listrecipes.data.ListRecipes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RecipeService{
        @GET("query")  //это поиск по названию рецепта, а как выводить весь список рецептов? и разделить его по категориям-мясо, рыба, завтраки и пр?
        suspend fun GetAllRecipes():List<ListRecipes>
}

var retrofit = Retrofit.Builder()
    .baseUrl("https://api.spoonacular.com/recipes/complexSearch?")  //куда добавить знак вопроса?
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var recipeService = retrofit.create(RecipeService::class.java)

