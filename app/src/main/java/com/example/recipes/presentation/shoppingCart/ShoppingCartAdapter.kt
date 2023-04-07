package com.example.recipes.presentation.shoppingCart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.R
import com.example.recipes.databinding.ItemShopCartBinding
import com.example.recipes.domain.shopItem.ShopItem

class ShoppingCartAdapter(val shopItem: List<ShopItem>): RecyclerView.Adapter<ShopItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shop_cart, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val item = shopItem[position]
        holder.bind(item)
//        прописать действия с элементом: написать имя продукта, изменить количество, редактировать имя продукта, удалить элемент, сделать неактивным элемент(по долгому нажатию)
    }

    override fun getItemCount(): Int {
        return shopItem.size
    }
}

class ShopItemViewHolder(view: View): RecyclerView.ViewHolder(view){
    val binding = ItemShopCartBinding.bind(view)
    fun bind(shopItem: ShopItem){
    //    binding.tvName.text = shopItem.    //вставить введенное название продукта
    //    binding.tvCount.text = shopItem.  //вставить введенное количество единиц продукта
    }
}