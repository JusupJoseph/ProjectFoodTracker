package com.example.projectfoodtracker.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projectfoodtracker.data.local.room.dao.NoteDao
import com.example.projectfoodtracker.domain.models.FoodsModel

@Database(entities = [FoodsModel::class], version = 3)
abstract class AppDatabase:RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

}