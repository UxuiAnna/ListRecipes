package com.example.listrecipies.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe (
    val name: String
    ): Parcelable // заполнить конструктор дата класса