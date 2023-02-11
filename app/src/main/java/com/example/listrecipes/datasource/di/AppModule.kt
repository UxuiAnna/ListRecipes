package com.example.listrecipes.datasource.di

import android.content.Context
import androidx.room.Room
import com.example.listrecipes.datasource.local.RecipeDao
import com.example.listrecipes.datasource.local.RecipesDataBase
import com.example.listrecipes.datasource.remote.RecipeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideRecipesDao(@ApplicationContext context: Context): RecipeDao{
        val db = Room.databaseBuilder(context, RecipesDataBase::class.java, "recipesDb").allowMainThreadQueries().build()
        return db.getRecipesDao()
    }

    @Provides
    @Singleton
    fun provideRecipeService(@ApplicationContext context: Context): RecipeService{
        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/recipes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RecipeService::class.java)
    }
}