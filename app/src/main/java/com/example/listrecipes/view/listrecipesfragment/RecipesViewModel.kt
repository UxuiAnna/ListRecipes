package com.example.listrecipes.view.listrecipesfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listrecipes.data.ListRecipes
import com.example.listrecipes.datasource.remote.recipeService
import com.example.listrecipes.view.RecipesApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipesListViewModel : ViewModel() {
    var db = RecipesApp.db

    var recipes = MutableLiveData<List<ListRecipes>>()

    fun loadRecipes() {
        viewModelScope.launch(Dispatchers.Main) {
                val result = recipeService.GetAllRecipes()
                recipes.value = result
        }
    }
    fun onRecipeFavoriteClick(recipe: ListRecipes){
        db.getRecipesDao().insertRecipe(recipe)
    }
}