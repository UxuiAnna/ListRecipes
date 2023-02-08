package com.example.listrecipes.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listrecipes.R
import com.example.listrecipes.domain.Recipe
import com.example.listrecipes.databinding.ItemRecipeBinding

interface RecipesAdapterListener{
    fun onRecipeItemClick(recipe: Recipe)
    fun onFavoriteClick(recipe: Recipe)
}

class ListRecipesAdapter(val recipe: List<Recipe>, val listener: RecipesAdapterListener ): RecyclerView.Adapter<RecipesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val recipe = recipe[position]
        holder.bind(recipe)

        holder.itemView.setOnClickListener {
            listener.onRecipeItemClick(recipe)
        }

        holder.itemView.setOnClickListener {
            listener.onFavoriteClick(recipe)
        }
    }

    override fun getItemCount(): Int {
        return recipe.size
    }
}

class RecipesViewHolder(view: View): RecyclerView.ViewHolder(view){
    val binding = ItemRecipeBinding.bind(view)
    fun bind(recipe: Recipe){
        binding.textNameRecipe.text = recipe.name
    }
}