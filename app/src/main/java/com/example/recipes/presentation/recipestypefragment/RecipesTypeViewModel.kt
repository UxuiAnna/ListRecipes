package com.example.recipes.presentation.recipestypefragment

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
class RecipesTypeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val recipeDao: RecipeDao,
    val recipeService: RecipeService
) : ViewModel() {

    private val args = RecipesTypeFragmentArgs.fromSavedStateHandle(savedStateHandle)

    val recipes = MutableLiveData<List<Recipe>>()
    private val errorLayoutIsVisible = MutableLiveData<Boolean>(false)

    fun loadListRecipesOnClickItem() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                errorLayoutIsVisible.value = false
                val result = recipeService.getAllRecipesForType(args.type).results
                recipes.value = result
            } catch (e: Exception){
                errorLayoutIsVisible.value = true
            }
        }
    }

    fun onRecipeFavoriteClick(recipe: Recipe){
        db.getRecipesDao().insertRecipe(recipe)
    }
}