package com.example.listrecipes.presentation.recipestypefragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listrecipes.datasource.local.RecipeDao
import com.example.listrecipes.datasource.remote.RecipeService
import com.example.listrecipes.domain.Recipe
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

    var recipes = MutableLiveData<List<Recipe>>()

    init {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                val result = recipeService.getAllRecipesForType(args.type)
                recipes.value = result
            } catch (e: Exception){

            }
        }
    }
}