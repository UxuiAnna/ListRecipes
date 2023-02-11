package com.example.listrecipes.datasource.local

import androidx.room.*
import com.example.listrecipes.domain.Recipe
import javax.inject.Inject

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes")
    fun getAllRecipes(): List<Recipe>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(recipe: Recipe)
    @Delete
    fun deleteRecipe(recipe: Recipe)
}