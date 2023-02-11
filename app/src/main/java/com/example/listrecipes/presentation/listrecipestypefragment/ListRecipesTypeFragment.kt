package com.example.listrecipes.presentation.listrecipestypefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.listrecipes.R
import com.example.listrecipes.databinding.FragmentListRecipesTypeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListRecipesTypeFragment: Fragment() {

    private var _binding: FragmentListRecipesTypeBinding? = null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_list_recipes_type, container, false)
    }
}