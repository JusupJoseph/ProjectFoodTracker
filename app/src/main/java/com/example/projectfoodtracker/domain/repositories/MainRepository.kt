package com.example.projectfoodtracker.domain.repositories

import com.example.projectfoodtracker.domain.models.FoodsModel

interface MainRepository {

    fun saveData(foodsModel: FoodsModel)

    fun getData(): FoodsModel

    fun getProgress():  FoodsModel

}