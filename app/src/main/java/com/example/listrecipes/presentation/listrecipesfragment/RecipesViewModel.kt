package com.example.listrecipes.presentation.listrecipesfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listrecipes.datasource.remote.ApiFactory.recipeService
import com.example.listrecipes.domain.ListRecipes
import com.example.listrecipes.datasource.local.RecipesAppDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipesListViewModel : ViewModel() {
    var db = RecipesAppDataBase.db

    var recipes = MutableLiveData<List<ListRecipes>>()

    fun loadRecipes() {
        viewModelScope.launch(Dispatchers.Main) {
                val result = recipeService.getAllRecipes()
                recipes.value = result
        }
    }
    fun onRecipeFavoriteClick(recipe: ListRecipes){
        db.getRecipesDao().insertRecipe(recipe)
    }
}