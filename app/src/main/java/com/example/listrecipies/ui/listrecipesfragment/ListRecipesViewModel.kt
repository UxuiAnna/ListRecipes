package com.example.listrecipies.ui.listrecipesfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listrecipies.data.Recipe
import com.example.listrecipies.datasource.recipeService
import com.example.listrecipies.datasource.remote.recipeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListrecipesViewModel : ViewModel() {

    var recipes = MutableLiveData<List<Recipe>>()

    fun loadRecipes() {
        viewModelScope.launch(Dispatchers.Main) {
                val result = recipeService.GetAllRecipes()
                recipes.value = result
        }
    }

}