package com.example.projectfoodtracker

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.projectfoodtracker.data.local.sharedpreferences.MainPreferenceData
import com.example.projectfoodtracker.data.local.room.AppDatabase
import com.example.projectfoodtracker.data.local.sharedpreferences.FoodPreferenceHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {

        private var context: Context? = null
        private var appDatabase: AppDatabase? = null
        lateinit var mainPreferenceData: MainPreferenceData

        fun getDataIntense(): AppDatabase?{
            if (appDatabase == null) {
                appDatabase = context?.let {
                    Room.databaseBuilder(
                        it,
                        AppDatabase::class.java,
                        "note_database"
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return appDatabase
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        initPreference()
        getDataIntense()
    }

    private fun initPreference() {
        mainPreferenceData = MainPreferenceData(this)
    }

}