package com.example.recipes.presentation.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.datasource.local.RecipeDao
import com.example.recipes.domain.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val recipeDao: RecipeDao
): ViewModel(){
    var favoriteRecipes = MutableLiveData<List<Recipe>>()

    fun updateFavoriteRecipes(){
        viewModelScope.launch(Dispatchers.Main) {
            val result = recipeDao.getAllRecipes()
            favoriteRecipes.value = result
        }
    }

    fun deleteFromFavoriteRecipes(recipe: Recipe){
        recipeDao.deleteRecipe(recipe)
        updateFavoriteRecipes()
    }
}