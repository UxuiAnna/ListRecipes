package com.example.recipes.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recipes.domain.recipe.Recipe

@Database(entities = [Recipe::class], version = 1)  //создание локальной БД посредством Room
abstract class RecipesDataBase : RoomDatabase() {

    abstract fun getRecipeDao(): RecipeDao
}

