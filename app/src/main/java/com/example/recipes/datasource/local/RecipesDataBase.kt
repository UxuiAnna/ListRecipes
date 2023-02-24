package com.example.recipes.datasource.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recipes.domain.Recipe
import dagger.hilt.android.HiltAndroidApp

@Database(entities = [Recipe::class], version = 1)  //создание локальной БД посредством Room
abstract class RecipesDataBase : RoomDatabase() {

    abstract fun getRecipesDao(): RecipeDao
}

