package com.example.listrecipes.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.listrecipes.domain.Recipe

@Database(entities = [Recipe::class], version = 1)
abstract class RecipesDataBase : RoomDatabase() {
    abstract fun getRecipesDao(): RecipeDao
}