package com.example.projectfoodtracker.data.local.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.navigation.NavController
import com.example.projectfoodtracker.R

class OnBoardingPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("onboard-preference", Context.MODE_PRIVATE)


    var isShow: Boolean?
        get() = sharedPreferences.getBoolean("isShow", false)
        set(value) = sharedPreferences.edit().putBoolean("isShow", true).apply()

}