package com.example.recipes.presentation.queryrecipes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.datasource.local.RecipeDao
import com.example.recipes.datasource.local.RecipesApp.Companion.db
import com.example.recipes.datasource.remote.RecipeService
import com.example.recipes.domain.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesQueryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val recipeDao: RecipeDao,
    val recipeService: RecipeService
): ViewModel() {

    private val args = RecipesQueryFragmentArgs.fromSavedStateHandle(savedStateHandle)
    val recipes = MutableLiveData<List<Recipe>>()
    val errorLayoutIsVisible = MutableLiveData<Boolean>(false)

    fun loadRecipesOnSearchButton() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                errorLayoutIsVisible.value = false
                val result = recipeService.getRecipesForSearch(args.query).results
                recipes.value = result
            } catch (e: Exception){
                errorLayoutIsVisible.value = true
            }
        }
    }

    fun onRecipeFavoriteClick(recipe: Recipe){
        recipeDao.insertRecipe(recipe)
    }

    fun onFavoriteDeleteClick(recipe: Recipe){
        recipeDao.deleteRecipe(recipe)
    }

}
