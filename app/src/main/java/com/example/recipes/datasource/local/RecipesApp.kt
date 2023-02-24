package com.example.recipes.datasource.local

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RecipesApp : Application() {
    companion object {
        lateinit var db: RecipesDataBase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, RecipesDataBase::class.java, "recipesDb")
            .allowMainThreadQueries().build()
    }
}