package com.example.listrecipes.view.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listrecipes.data.ListRecipes
import com.example.listrecipes.view.RecipesApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel: ViewModel() {
    val db = RecipesApp.db
    var favoritesRecipes = MutableLiveData<List<ListRecipes>>()

    fun loadFavoriteRecipes(){
        viewModelScope.launch(Dispatchers.Main) {
            val result = db.getRecipesDao().getAllRecipes()
            favoritesRecipes.value = result
        }
    }

    fun deleteFromFavorite (recipe: ListRecipes){
        db.getRecipesDao().deleteRecipe(recipe)
        loadFavoriteRecipes()
    }

}