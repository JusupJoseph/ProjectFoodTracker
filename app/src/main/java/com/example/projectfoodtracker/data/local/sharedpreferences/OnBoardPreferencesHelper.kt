package com.example.projectfoodtracker.data.local.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

class OnBoardPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("onboard-preference", Context.MODE_PRIVATE)


    var isShow: Boolean
        get() = sharedPreferences.getBoolean("isShow", false)
        set(value) = sharedPreferences.edit().putBoolean("isShow", value).apply()
}