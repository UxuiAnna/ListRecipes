package com.example.recipes.presentation.searchrecipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.R
import com.example.recipes.databinding.ItemRecipeBinding
import com.example.recipes.domain.Recipe

interface SearchAdapterListener {
    fun onRecipeItemClick(recipe: Recipe)
}

class RecipesSearchAdapter(val recipes: List<Recipe>, val listener: SearchAdapterListener) :
    RecyclerView.Adapter<RecipesSearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesSearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipesSearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesSearchViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)

        holder.itemView.setOnClickListener {
            listener.onRecipeItemClick(recipe)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}

class RecipesSearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemRecipeBinding.bind(view)
    fun bind(recipe: Recipe) {
        binding.textNameRecipe.text = recipe.title
//      binding.imageRecipe.setImageResource()
    }

}