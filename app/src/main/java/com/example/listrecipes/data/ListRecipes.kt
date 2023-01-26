package com.example.listrecipes.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Recipes")
data class ListRecipes (
    @PrimaryKey val name: String
): Parcelable
