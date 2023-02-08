package com.example.listrecipes.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Recipes")
data class Recipe (
    @PrimaryKey
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String
): Parcelable


//https://spoonacular.com/food-api/docs#Meal-Types разделение по категориямЖ завтрак, обед и пр
