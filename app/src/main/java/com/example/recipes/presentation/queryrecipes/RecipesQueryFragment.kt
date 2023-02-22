package com.example.recipes.presentation.queryrecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipes.databinding.FragmentRecipesQueryBinding
import com.example.recipes.domain.Recipe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesQueryFragment : Fragment(), QueryAdapterListener {
    private var _binding: FragmentRecipesQueryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RecipesQueryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipesQueryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadRecipesOnSearchButton()
        viewModel.recipes.observe(viewLifecycleOwner) { recipes ->
            val recipesAdapter = RecipesQueryAdapter(recipes, this)
            binding.rVQuery.adapter = recipesAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //открыть страницу рецепта из списка (со списка из поиска)
    override fun onRecipeItemClick(recipe: Recipe) {
        val action =
            RecipesQueryFragmentDirections.actionRecipesQueryFragmentToPageRecipeFragment()
        findNavController().navigate(action)
    }

    override fun onRecipeFavoriteClick(recipe: Recipe) {
        viewModel.onRecipeFavoriteClick(recipe)
    }
}

