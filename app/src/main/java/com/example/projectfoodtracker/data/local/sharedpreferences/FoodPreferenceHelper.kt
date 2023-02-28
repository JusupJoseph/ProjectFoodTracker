package com.example.projectfoodtracker.data.local.sharedpreferences

class FoodPreferenceHelper(
    private val preferenceHelper: MainPreferenceData
) {
   var name: String?
    get() = preferenceHelper().getString(
        PreferenceConstances.NAME, "null"
    )
    set(value) =preferenceHelper().edit().putString(
        PreferenceConstances.NAME, value
    ).apply()

    var calories: String?
        get() = preferenceHelper().getString(
            PreferenceConstances.CALORIES, "null"
        )
        set(value) =preferenceHelper().edit().putString(
            PreferenceConstances.CALORIES, value
        ).apply()

    var data: String?
        get() = preferenceHelper().getString(
            PreferenceConstances.DATA, "null"
        )
        set(value) =preferenceHelper().edit().putString(
            PreferenceConstances.DATA, value
        ).apply()

}