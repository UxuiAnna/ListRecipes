package com.example.listrecipes.datasource.local

import androidx.room.*
import com.example.listrecipes.data.ListRecipes

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes")
    fun getAllRecipes(): List<ListRecipes>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(recipe: ListRecipes)
    @Delete
    fun deleteRecipe(recipe: ListRecipes)
}