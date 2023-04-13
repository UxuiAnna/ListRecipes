package com.example.recipes.presentation.pagerecipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.recipes.R

import com.example.recipes.databinding.FragmentPageRecipeBinding
import com.example.recipes.domain.recipe.Recipe

class PageRecipeFragment : Fragment() {
    private var _binding: FragmentPageRecipeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PageRecipeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPageRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadRecipesInfo()

        viewModel.recipe.observe(viewLifecycleOwner){recipe->

        }

        viewModel.isInFavorite.observe(viewLifecycleOwner){isInFavorite->
            if(isInFavorite)
                binding.favorite.setImageResource(R.drawable.favorite)
            else
                binding.favorite.setImageResource(R.drawable.delete)
        }

        viewModel.errorLayoutIsVisible.observe(viewLifecycleOwner){isVisible->
            if(isVisible)
                showError()
            else
                hideError()
        }
    }

    fun showError() {
        binding.errorView.visibility = View.VISIBLE
    }

    fun hideError() {
        binding.errorView.visibility = View.INVISIBLE
    }

    // эти функции исполняет адаптер, но на странице рецепта нет адаптера. Куда их подключить?
    fun onRecipeFavoriteClick(recipe: Recipe){
        viewModel.onRecipeFavoriteClick(recipe)
    }

    fun onFavoriteDeleteClick(recipe: Recipe) {
        viewModel.onFavoriteDeleteClick(recipe)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}