package com.example.recipes.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject
import javax.inject.Singleton

//class Recipe - является таблицей в БД
@Singleton
@Entity(tableName = "recipes")
data class Recipe (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String
)

