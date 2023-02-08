package com.example.listrecipes.presentation.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listrecipes.domain.Recipe
import com.example.listrecipes.datasource.local.RecipesAppDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel: ViewModel() {
    val db = RecipesAppDataBase.db
    var favoritesRecipe = MutableLiveData<List<Recipe>>()

    fun loadFavoriteRecipes(){
        viewModelScope.launch(Dispatchers.Main) {
            val result = db.getRecipesDao().getAllRecipes()
            favoritesRecipe.value = result
        }
    }

    fun deleteFromFavorite (recipe: Recipe){
        db.getRecipesDao().deleteRecipe(recipe)
        loadFavoriteRecipes()
    }

}