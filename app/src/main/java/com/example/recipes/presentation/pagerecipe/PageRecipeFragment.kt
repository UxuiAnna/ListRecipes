package com.example.recipes.presentation.pagerecipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.example.recipes.databinding.FragmentPageRecipeBinding
import com.example.recipes.presentation.mainmenu.MainMenuFragmentDirections
import com.example.recipes.presentation.recipestypefragment.RecipesTypeViewModel

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
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}