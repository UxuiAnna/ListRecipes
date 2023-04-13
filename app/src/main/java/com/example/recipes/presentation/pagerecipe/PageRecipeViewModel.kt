package com.example.recipes.presentation.pagerecipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.datasource.local.RecipeDao
import com.example.recipes.datasource.remote.RecipeService
import com.example.recipes.domain.recipe.InfoRecipe
import com.example.recipes.domain.recipe.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PageRecipeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val recipeDao: RecipeDao,
    val recipeService: RecipeService
) : ViewModel() {

    private val args = PageRecipeFragmentArgs.fromSavedStateHandle(savedStateHandle)
    val recipe = MutableLiveData<InfoRecipe>()
    val isInFavorite = MutableLiveData(false)
    val errorLayoutIsVisible = MutableLiveData<Boolean>(false)

    fun loadRecipesInfo() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                errorLayoutIsVisible.value = false
                val infoResult = recipeService.getInfoRecipe(args.id)
                recipe.value = infoResult
            } catch (e: Exception) {
                errorLayoutIsVisible.value = true
            }
        }
    }

    fun loadListRecipesOnClickItem() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                errorLayoutIsVisible.value = false
                val recipeFromApi = recipeService.getInfoRecipe(args.id)
                val favoritesRecipes = recipeDao.getAllRecipes()
                isInFavorite.value = (favoritesRecipes.find { it.id == recipeFromApi.id } != null)
                recipe.value = recipeFromApi
            } catch (e: Exception) {
                errorLayoutIsVisible.value = true
            }
        }
    }

    fun onRecipeFavoriteClick(recipe: Recipe) {
        recipeDao.insertRecipe(recipe)
        loadListRecipesOnClickItem()
    }

    fun onFavoriteDeleteClick(recipe: Recipe) {
        recipeDao.deleteRecipe(recipe)
        loadListRecipesOnClickItem()
    }
}