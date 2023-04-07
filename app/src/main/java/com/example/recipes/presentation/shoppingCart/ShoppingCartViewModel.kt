package com.example.recipes.presentation.shoppingCart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipes.datasource.ShopListRepositoryImpl
import com.example.recipes.domain.shopItem.DeleteShopItemUseCase
import com.example.recipes.domain.shopItem.EditShopItemUseCase
import com.example.recipes.domain.shopItem.GetShopListUseCase
import com.example.recipes.domain.shopItem.ShopItem

class ShoppingCartViewModel: ViewModel() {

    private  val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnabledState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled =! shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}