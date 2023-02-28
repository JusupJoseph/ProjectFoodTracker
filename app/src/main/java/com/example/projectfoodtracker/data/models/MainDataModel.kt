package com.example.projectfoodtracker.data.models

import com.example.projectfoodtracker.data.local.sharedpreferences.FoodPreferenceHelper
import com.example.projectfoodtracker.domain.models.FoodsModel

data class MainDataModel (
    val name: String,
    val calories: String,
    val data: String,
)

fun MainDataModel.toDomain() = FoodsModel(
    name = name,
    calories = calories,
    data = data
)

fun FoodsModel.toDomain() =MainDataModel(
    name = name,
    calories = calories,
    data = data
)