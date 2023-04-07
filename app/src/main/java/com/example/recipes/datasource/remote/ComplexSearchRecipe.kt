package com.example.recipes.datasource.remote

import com.example.recipes.domain.recipe.Recipe


data class ComplexSearchRecipe(
    //как создать таблицу из List<Recipe> ??
    val results: List<Recipe>
)
