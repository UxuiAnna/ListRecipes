package com.example.recipes.domain

data class InfoRecipe(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String,
    val servings: Int,
    val readyInMinutes: Int,
    val extendedIngredients: Aisle  //что это? Как его заполнить?
    val //не могу понять где само описание процесса приготовления
)


data class Aisle(

)