package com.example.recipes.domain.recipe

data class InfoRecipe(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String,
    val sourceUrl: String,
    val servings: Int,
    val readyInMinutes: Int,
    val extendedIngredients: List<ExtendedIngredients>  //что это? Как его заполнить?
    )


data class ExtendedIngredients(
    val aisle: String,
    val amount: Double
)