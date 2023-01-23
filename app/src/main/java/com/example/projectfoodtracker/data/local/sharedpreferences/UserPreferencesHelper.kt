package com.example.projectfoodtracker.data.local.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import com.example.projectfoodtracker.R

class PreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("onboard-preference", Context.MODE_PRIVATE)


    var isShow: Boolean
        get() = sharedPreferences.getBoolean("isShow", false)
        set(value) = sharedPreferences.edit().putBoolean("isShow", value).apply()

    var username: String?
        get() = sharedPreferences.getString("username", "")
        set(value) = sharedPreferences.edit().putString("username", value).apply()

    var isAuthorized: Boolean
        get() = sharedPreferences.getBoolean("isAuthorized", false)
        set(value) = sharedPreferences.edit().putBoolean("isAuthorized", value).apply()

}