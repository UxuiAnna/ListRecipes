package com.example.listrecipes.presentation.mainmenufragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.listrecipes.databinding.FragmentMainBinding
import com.example.listrecipes.domain.ListRecipes
import com.example.listrecipies.databinding.FragmentMainBinding


class MainMenuFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainMenuFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadMenu()

        //подключаю слушатель на иконки в главном меню. по клику на иконку должен открыться список с рецептами данного раздела
        binding.cvBreakfast.setOnClickListener { openListBreakfast(listRecipes) }   //нужно же подключить навконтроллер в фрагмент? и в слушатель передать сразу список с рецептами завтраков?
        binding.cvSideDish.setOnClickListener{ openListPorridge() }
    }

    private fun openListBreakfast(listRecipes: ListRecipes){
        val action = MainMenuFragmentDirections.actionMainMenuFragmentToRecipesListFragment(listRecipes) //как передать список? если поставила галочку при создании safe args в навграфе
        findNavController().navigate(action)
    }

    private fun openListPorridge(listRecipes: ListRecipes){
        val action = MainMenuFragmentDirections.actionMainMenuFragmentToRecipesListFragment(listRecipes)
        findNavController().navigate(action)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
