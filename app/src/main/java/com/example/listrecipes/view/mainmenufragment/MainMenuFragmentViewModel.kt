package com.example.listrecipes.view.mainmenufragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainMenuFragmentViewModel: ViewModel() {
    var menuItemsIsVisible = MutableLiveData<Boolean>(true)

    fun loadMenu(){
        viewModelScope.launch(Dispatchers.Main){
            try {
                menuItemsIsVisible.value = true
            }catch (e: Exception){
                menuItemsIsVisible.value = false
            }
        }
    }
}