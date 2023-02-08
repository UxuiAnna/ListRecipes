package com.example.listrecipes.presentation.listrecipes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listrecipes.datasource.remote.ApiFactory.recipeService
import com.example.listrecipes.domain.Recipe
import com.example.listrecipes.datasource.local.RecipesAppDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipesListViewModel : ViewModel() {
    var db = RecipesAppDataBase.db

    var recipe = MutableLiveData<List<Recipe>>()

    fun loadRecipes() {
        viewModelScope.launch(Dispatchers.Main) {
                val result = recipeService.getAllRecipes()
                recipe.value = result
        }
    }
    fun onRecipeFavoriteClick(recipe: Recipe){
        db.getRecipesDao().insertRecipe(recipe)
    }
}