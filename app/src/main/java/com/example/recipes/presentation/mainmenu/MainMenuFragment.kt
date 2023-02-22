package com.example.recipes.presentation.mainmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.recipes.databinding.FragmentMainBinding

class MainMenuFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

 //   private val viewModel: MainMenuFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //подключаю слушатель на иконки в главном меню. по клику на иконку должен открыться список с рецептами данного раздела
        binding.cvBreakfast.setOnClickListener { openRecipesForType("breakfast") }
        binding.cvSideDish.setOnClickListener{ openRecipesForType("side dish") }
        binding.cvDesert.setOnClickListener { openRecipesForType("desert") }
        binding.cvDrink.setOnClickListener { openRecipesForType("drink") }
        binding.cvMainCourse.setOnClickListener { openRecipesForType("main course") }
        binding.cvSalad.setOnClickListener { openRecipesForType("salad") }
        binding.cvSoup.setOnClickListener { openRecipesForType("soup") }
        binding.searchButton.setOnClickListener { openRecipesForQuery("query") }
    }

    private fun openRecipesForType(type: String){
        val action = MainMenuFragmentDirections.actionMainMenuFragmentToRecipesTypeFragment(type)
        findNavController().navigate(action)
    }

    private fun openRecipesForQuery(query: String){
        val action = MainMenuFragmentDirections.actionMainMenuFragmentToRecipesQueryFragment(query)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
