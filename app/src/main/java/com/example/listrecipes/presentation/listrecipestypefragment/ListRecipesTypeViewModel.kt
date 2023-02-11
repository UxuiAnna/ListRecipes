package com.example.listrecipes.presentation.listrecipestypefragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listrecipes.datasource.local.RecipeDao
import com.example.listrecipes.datasource.local.RecipesAppDataBase
import com.example.listrecipes.datasource.remote.RecipeService
import com.example.listrecipes.domain.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListRecipesTypeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val recipeDao: RecipeDao,
    val recipeService: RecipeService
) : ViewModel() {

    private val args = ListRecipesTypeFragmentArgs.fromSavedStateHandle(savedStateHandle)

    var recipes = MutableLiveData<List<Recipe>>()

    fun loadRecipes() {
        viewModelScope.launch(Dispatchers.Main) {
            val result = recipeService.getAllRecipesForType(args.type)
        }
    }
}