package com.example.recipes.presentation.searchrecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.example.recipes.databinding.FragmentRecipesSearchBinding

class RecipesSearchFragment : Fragment() {
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
        viewModel.loadListRecipesFromSearch()
        viewModel.recipes.observe(viewLifecycleOwner){
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

