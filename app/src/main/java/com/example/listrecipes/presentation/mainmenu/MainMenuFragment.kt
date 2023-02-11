package com.example.listrecipes.presentation.mainmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.listrecipes.databinding.FragmentMainBinding
import com.example.listrecipes.domain.Recipe


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

        //подключаю слушатель на иконки в главном меню. по клику на иконку должен открыться список с рецептами данного раздела
        binding.cvBreakfast.setOnClickListener { openRecipiesForType("breakfast") }   //нужно же подключить навконтроллер в фрагмент? и в слушатель передать сразу список с рецептами завтраков?
        binding.cvSideDish.setOnClickListener{ openRecipiesForType("side dish") }
    }

    private fun openRecipiesForType(type: String){
        val action = MainMenuFragmentDirections.actionMainMenuFragmentToRecipesTypeFragment(type) //как передать список? если поставила галочку при создании safe args в навграфе
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
