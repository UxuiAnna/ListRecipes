package com.example.recipes.datasource.remote

import androidx.room.Embedded
import androidx.room.Entity
import com.example.recipes.domain.Recipe


data class ComplexSearchRecipe(
    //как создать таблицу из List<Recipe> ??
    val results: List<Recipe>
)
