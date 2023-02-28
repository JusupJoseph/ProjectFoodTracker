package com.example.projectfoodtracker.data.repositories

import com.example.projectfoodtracker.data.local.sharedpreferences.FoodPreferenceHelper
import com.example.projectfoodtracker.data.models.MainDataModel
import com.example.projectfoodtracker.data.models.toDomain
import com.example.projectfoodtracker.domain.models.FoodsModel
import com.example.projectfoodtracker.domain.repositories.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val preferenceHelper: FoodPreferenceHelper,
) : MainRepository {
    override fun saveData(foodsModel: FoodsModel) {
        preferenceHelper.apply {
            name = foodsModel.name
            calories = foodsModel.calories
            data = foodsModel.data

        }
    }

    override fun getData(): FoodsModel {
        preferenceHelper.apply {
            return MainDataModel(
                name = name.toString(),
                calories = calories.toString(),
                data = data.toString()
            ).toDomain()
        }
    }
}