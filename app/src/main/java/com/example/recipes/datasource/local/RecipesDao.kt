package com.example.recipes.datasource.local

import androidx.room.*
import com.example.recipes.domain.Recipe

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes")
    fun getAllRecipes(): List<Recipe>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(recipe: Recipe)
    @Delete
    fun deleteRecipe(recipe: Recipe)
}