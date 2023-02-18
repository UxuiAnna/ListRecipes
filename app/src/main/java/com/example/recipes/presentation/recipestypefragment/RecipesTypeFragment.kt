package com.example.recipes.presentation.recipestypefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipes.databinding.FragmentRecipesTypeBinding
import com.example.recipes.domain.Recipe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesTypeFragment: Fragment(),TypeAdapterListener {

    private var _binding: FragmentRecipesTypeBinding? = null
    private val binding get()= _binding!!
    private val viewModel: RecipesTypeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipesTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadListRecipesOnClickItem()
        viewModel.recipes.observe(viewLifecycleOwner){ recipes ->
            val recipesAdapter = RecipesTypeAdapter(recipes, this)
            binding.rVType.adapter = recipesAdapter
        }
    }

    override fun onRecipeItemClick(recipe: Recipe) {
        val action = RecipesTypeFragmentDirections.actionRecipesTypeFragmentToPageRecipeFragment()
        findNavController().navigate(action)
    }
}