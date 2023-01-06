package com.example.listrecipies.ui.listrecipesfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.listrecipies.databinding.FragmentListRecipiesBinding
import com.example.listrecipies.ui.adapters.ListRecipesAdapter


class ListRecipesFragment : Fragment() {

    private var _binding: FragmentListRecipiesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListrecipesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListRecipiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadRecipes()
        viewModel.recipes.observe(viewLifecycleOwner){recipes ->
            val adapter = ListRecipesAdapter(recipes)
            binding.recyclerView.adapter = adapter
        }
    }

}