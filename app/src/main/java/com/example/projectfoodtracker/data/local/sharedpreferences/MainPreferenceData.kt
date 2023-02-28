package com.example.projectfoodtracker.data.local.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

class MainPreferenceData(context: Context) {

    private var sharedPreference: SharedPreferences =
        context.getSharedPreferences("foods", Context.MODE_PRIVATE)

    operator fun invoke(): SharedPreferences = sharedPreference

    fun name (nameKey: String){
        sharedPreference.edit()?.remove(nameKey)?.apply()
    }

    fun calories (calories : String){
         sharedPreference.edit().remove(calories)?.apply()
    }

    fun data (data: String): Boolean{
        return sharedPreference.getBoolean(data, false)
    }

    fun putValue(nameKey: String, boolean: Boolean) {
    sharedPreference.edit()?.putBoolean(nameKey, boolean)?.apply()
    }

    var progressBar: String?
        get() = sharedPreference.getString("foods", "")
        set(value) = sharedPreference.edit().putString("foods", value).apply()
}