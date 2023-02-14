package com.example.listrecipes.presentation.recipestypefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.listrecipes.databinding.FragmentRecipesTypeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesTypeFragment: Fragment() {

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

        viewModel.loadRecipes()
        viewModel.recipes.observe(viewLifecycleOwner){ recipes ->

        }
    }
}