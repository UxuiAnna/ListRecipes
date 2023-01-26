package com.example.listrecipes.view.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.listrecipes.data.ListRecipes
import com.example.listrecipes.databinding.FragmentListRecipiesBinding

class FavoritesFragment : Fragment(),FavoritesAdapterListener {

        private var _binding: FragmentListRecipiesBinding? = null
        private val binding get() = _binding!!
        private val viewModel: FavoritesViewModel by viewModels()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentListRecipiesBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            viewModel.loadFavoriteRecipes()
            viewModel.favoritesRecipes.observe(viewLifecycleOwner){ recipes ->
                val adapter = FavoritesAdapter(recipes, this)
                binding.recyclerView.adapter = adapter
            }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

    override fun onRecipeItemClick(recipe: ListRecipes) {
        TODO("Not yet implemented")
    }

    override fun deleteFromFavorite(recipe: ListRecipes) {
        viewModel.deleteFromFavorite(recipe)
    }

}