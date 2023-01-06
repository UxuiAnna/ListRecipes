package com.example.listrecipies.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listrecipies.R
import com.example.listrecipies.data.Recipe
import com.example.listrecipies.databinding.ItemRecipeBinding

class ListRecipesAdapter(val recipes: List<Recipe>): RecyclerView.Adapter<RecipesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}

class RecipesViewHolder(view: View): RecyclerView.ViewHolder(view){
    val binding = ItemRecipeBinding.bind(view)
    fun bind(recipe: Recipe){
        binding.textName.text = recipe.name
    }
}