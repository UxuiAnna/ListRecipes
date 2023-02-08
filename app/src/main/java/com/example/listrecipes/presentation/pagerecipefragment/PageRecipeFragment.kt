package com.example.listrecipes.presentation.pagerecipefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.listrecipes.databinding.FragmentPageRecipeBinding

class PageRecipeFragment : Fragment() {
    private var _binding: FragmentPageRecipeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPageRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}