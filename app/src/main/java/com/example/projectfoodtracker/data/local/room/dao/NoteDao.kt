package com.example.projectfoodtracker.data.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projectfoodtracker.domain.models.FoodsModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(foodsModel: FoodsModel)

    @Delete
    fun delete(foodsModel: FoodsModel)

    @Query("SELECT * FROM note_table")
    fun getAllModels(): LiveData<List<FoodsModel>>

}