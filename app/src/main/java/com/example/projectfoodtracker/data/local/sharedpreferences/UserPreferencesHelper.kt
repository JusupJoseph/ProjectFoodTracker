package com.example.projectfoodtracker.data.local.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

class UserPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user-preference", Context.MODE_PRIVATE)

    var username: String?
        get() = sharedPreferences.getString("username", "")
        set(value) = sharedPreferences.edit().putString("username", value).apply()

    var isAuthorized: Boolean
        get() = sharedPreferences.getBoolean("isAuthorized", false)
        set(value) = sharedPreferences.edit().putBoolean("isAuthorized", value).apply()
}