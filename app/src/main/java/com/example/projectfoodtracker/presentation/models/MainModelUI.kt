package com.example.projectfoodtracker.presentation.models

import androidx.room.Entity
import com.example.projectfoodtracker.domain.models.FoodsModel
import com.example.projectfoodtracker.presentation.base.IBaseDiffUtil

@Entity(tableName = "note_table")
data class MainModelUI(
    override val id: Int,
    val name: String,
    val calories: String,
    val data: String
) : IBaseDiffUtil<Int>

fun FoodsModel.toUI() = MainModelUI(
   name = name,
   calories = calories,
    data = data,
    id = id,
)

fun MainModelUI.toUI() = FoodsModel(
    name = name,
    data = data,
    calories = calories,
)
