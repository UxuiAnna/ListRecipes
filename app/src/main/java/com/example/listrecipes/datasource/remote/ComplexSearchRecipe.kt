package com.example.listrecipes.datasource.remote

import com.example.listrecipes.domain.Recipe

data class ComplexSearchRecipe(
    val results: List<Recipe>
)
