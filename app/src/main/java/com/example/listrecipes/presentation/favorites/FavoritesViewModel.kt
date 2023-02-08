package com.example.listrecipes.presentation.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listrecipes.domain.ListRecipes
import com.example.listrecipes.datasource.local.RecipesAppDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel: ViewModel() {
    val db = RecipesAppDataBase.db
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