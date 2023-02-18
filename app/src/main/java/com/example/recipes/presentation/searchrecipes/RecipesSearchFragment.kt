package com.example.recipes.presentation.searchrecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.recipes.databinding.FragmentRecipesSearchBinding
import com.example.recipes.domain.Recipe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesSearchFragment : Fragment(), SearchAdapterListener {
    private var _binding: FragmentRecipesSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RecipesSearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipesSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadRecipesOnSearchButton()
        viewModel.recipes.observe(viewLifecycleOwner){ recipes ->
            val recipesAdapter = RecipesSearchAdapter(recipes, this)
            binding.rVSearch.adapter = recipesAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onRecipeItemClick(recipe: Recipe) {
        TODO("Not yet implemented")
    }
}

