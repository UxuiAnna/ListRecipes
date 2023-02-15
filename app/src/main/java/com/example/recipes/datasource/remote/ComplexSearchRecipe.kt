package com.example.recipes.datasource.remote

import com.example.recipes.domain.Recipe

data class ComplexSearchRecipe(
    val results: List<Recipe>
)
