package com.example.recipes.presentation.recipestypefragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.R
import com.example.recipes.databinding.ItemRecipeBinding
import com.example.recipes.domain.Recipe

interface TypeAdapterListener {
    fun onRecipeItemClick(recipe: Recipe)
    fun onRecipeFavoriteClick(recipe: Recipe)
}

class RecipesTypeAdapter(val recipes: List<Recipe>,val listener: TypeAdapterListener) :
    RecyclerView.Adapter<RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)

        holder.itemView.setOnClickListener {
            listener.onRecipeItemClick(recipe)
        }

        holder.binding.iconFavorite.setOnClickListener{
            listener.onRecipeFavoriteClick(recipe)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}

class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemRecipeBinding.bind(view)

    fun bind(recipe: Recipe) {
        binding.textNameRecipe.text = recipe.title
        binding.imageRecipe.setImageResource()//как передать ссылку на картинку?
    }
}

