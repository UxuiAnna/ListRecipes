package com.example.recipes.presentation.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.R
import com.example.recipes.databinding.ItemRecipeBinding
import com.example.recipes.domain.Recipe

interface FavoritesAdapterListener{
    fun onRecipeItemClick(recipe: Recipe)
    fun deleteFromFavoriteRecipes(recipe: Recipe)
}
class FavoriteAdapter(val recipes: List<Recipe>, val listener: FavoritesAdapterListener): RecyclerView.Adapter<RecipesFavoriteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesFavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe,parent, false)
        return RecipesFavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesFavoriteViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
        holder.itemView.setOnClickListener {
            listener.onRecipeItemClick(recipe)
        }

        holder.binding.iconDelete.setOnClickListener {
            listener.deleteFromFavoriteRecipes(recipe)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}

class RecipesFavoriteViewHolder(view: View): RecyclerView.ViewHolder(view){
    val binding = ItemRecipeBinding.bind(view)
    fun bind(recipe: Recipe){
        binding.textNameRecipe.text = recipe.title
//      binding.imageRecipe.setImageResource()
        binding.iconFavorite.setImageResource(R.drawable.favorite)
    }

}