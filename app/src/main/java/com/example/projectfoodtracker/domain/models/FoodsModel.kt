package com.example.projectfoodtracker.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.projectfoodtracker.presentation.base.IBaseDiffUtil

@Entity(tableName = "note_table")
data class FoodsModel(
    val name: String,
    val calories: String,
    val data: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

