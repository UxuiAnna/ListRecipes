package com.example.recipes.presentation.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipes.databinding.FragmentFavoritesBinding
import com.example.recipes.domain.Recipe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment(), FavoritesAdapterListener {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FavoritesViewModel by viewModels()

//    private val args: FragmentFavoritesArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.updateFavoriteRecipes()
        viewModel.favoriteRecipes.observe(viewLifecycleOwner){ recipes ->
            val adapter = FavoriteAdapter(recipes, this)
            binding.rVFavorites.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onRecipeItemClick(recipe: Recipe) {
        val action = FavoritesFragmentDirections.actionFavoritesFragment2ToPageRecipeFragment(id)
        findNavController().navigate(action)
    }

    override fun deleteFromFavoriteRecipes(recipe: Recipe) {
        viewModel.deleteFromFavoriteRecipes(recipe)
    }
}

