package com.example.recipes.presentation.recipestypefragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.datasource.local.RecipeDao
import com.example.recipes.datasource.remote.RecipeService
import com.example.recipes.domain.recipe.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesTypeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val recipeDao: RecipeDao,
    val recipeService: RecipeService
) : ViewModel() {

    private val args = RecipesTypeFragmentArgs.fromSavedStateHandle(savedStateHandle)

    val recipes = MutableLiveData<List<Recipe>>()
    val errorLayoutIsVisible = MutableLiveData<Boolean>(false)

    fun loadListRecipesOnClickItem() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                errorLayoutIsVisible.value = false
                val recipesFromApi = recipeService.getAllRecipesForType(args.type).results
                val favoritesRecipes = recipeDao.getAllRecipes()
                val result = recipesFromApi.map{recipe->
                    if(favoritesRecipes.find { it.id == recipe.id } != null)
                        recipe.copy(isInFavorite = true)
                    else
                        recipe
                }
                recipes.value = result
            } catch (e: Exception){
                Log.d("error", e.toString())
                errorLayoutIsVisible.value = true
            }
        }
    }

    fun onRecipeFavoriteClick(recipe: Recipe){
        recipeDao.insertRecipe(recipe)
        loadListRecipesOnClickItem()
    }

    fun onFavoriteDeleteClick(recipe: Recipe){
        recipeDao.deleteRecipe(recipe)
        loadListRecipesOnClickItem()
    }
}