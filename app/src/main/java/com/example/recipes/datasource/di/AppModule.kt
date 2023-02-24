package com.example.recipes.datasource.di

import android.content.Context
import androidx.room.Room
import com.example.recipes.datasource.local.RecipeDao
import com.example.recipes.datasource.local.RecipesDataBase
import com.example.recipes.datasource.remote.RecipeService
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
    fun provideRecipesBD(@ApplicationContext context: Context): RecipesDataBase {
        return Room.databaseBuilder(context, RecipesDataBase::class.java, "recipesDb")
            .allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideRecipesDao(database: RecipesDataBase): RecipeDao{
        return database.getRecipesDao()
    }

    @Provides
    @Singleton
    fun provideRecipeService(): RecipeService{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/recipes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RecipeService::class.java)
    }
}