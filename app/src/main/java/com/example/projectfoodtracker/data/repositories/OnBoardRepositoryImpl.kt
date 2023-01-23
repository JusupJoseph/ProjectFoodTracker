package com.example.projectfoodtracker.data.repositories

import com.example.projectfoodtracker.data.local.sharedpreferences.OnBoardPreferencesHelper
import com.example.projectfoodtracker.domain.repositories.OnBoardingRepository
import javax.inject.Inject

class OnBoardRepositoryImpl @Inject constructor(
    private val preferences: OnBoardPreferencesHelper
) : OnBoardingRepository {

    override fun isShow(boolean: Boolean) {
        preferences.isShow = boolean
    }

    override fun getInfo() = preferences.isShow
}