package com.example.recipes.presentation.queryrecipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.R
import com.example.recipes.databinding.ItemRecipeBinding
import com.example.recipes.domain.Recipe
import javax.inject.Inject

interface QueryAdapterListener {
    fun onRecipeItemClick(recipe: Recipe)
    fun onRecipeFavoriteClick(recipe: Recipe)
}

class RecipesQueryAdapter @Inject constructor(val recipes: List<Recipe>, val listener: QueryAdapterListener) :
    RecyclerView.Adapter<RecipesQueryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesQueryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipesQueryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesQueryViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)

        holder.itemView.setOnClickListener {
            listener.onRecipeItemClick(recipe)
        }

        holder.binding.iconFavorite.setOnClickListener {
            listener.onRecipeFavoriteClick(recipe)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}

class RecipesQueryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemRecipeBinding.bind(view)
    fun bind(recipe: Recipe) {
        binding.textNameRecipe.text = recipe.title
//      binding.imageRecipe.setImageResource()
    }

}