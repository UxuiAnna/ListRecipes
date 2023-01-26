package com.example.listrecipes.view.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listrecipes.R
import com.example.listrecipes.data.ListRecipes
import com.example.listrecipes.databinding.ItemRecipeBinding

interface FavoritesAdapterListener{
    fun onRecipeItemClick(recipe: ListRecipes)
    fun deleteFromFavorite(recipe: ListRecipes)
}
class FavoritesAdapter(val recipe: List<ListRecipes>, val listener: FavoritesAdapterListener): RecyclerView.Adapter<FavoritesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val recipe = recipe[position]
        holder.bind(recipe)

        holder.itemView.setOnClickListener {
            listener.onRecipeItemClick(recipe)
        }

        holder.binding.
    }
    override fun getItemCount(): Int {
        return recipe.size
    }
}

class FavoritesViewHolder(view: View): RecyclerView.ViewHolder(view){
    val binding = ItemRecipeBinding.bind(view)
    fun bind(recipe: ListRecipes){
        binding.textNameRecipe.text = recipe.name
    }
}