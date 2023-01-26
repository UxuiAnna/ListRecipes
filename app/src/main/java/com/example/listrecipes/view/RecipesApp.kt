package com.example.listrecipes.view

import android.app.Application
import androidx.room.Room
import com.example.listrecipes.datasource.local.RecipesDataBase

class RecipesApp: Application(){
    companion object{
        lateinit var db: RecipesDataBase
    }

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(this, RecipesDataBase::class.java, "recipesDb").allowMainThreadQueries().build()
    }
}