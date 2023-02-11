package com.example.listrecipes.datasource.local

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
abstract class RecipesAppDataBase: Application(){
    companion object{
        lateinit var db: RecipesDataBase
    }

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(this, RecipesDataBase::class.java, "recipesDb").allowMainThreadQueries().build()
    }
}