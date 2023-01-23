package com.example.projectfoodtracker.data.repositories

import com.example.projectfoodtracker.data.local.sharedpreferences.UserPreferencesHelper
import com.example.projectfoodtracker.domain.repositories.OnBoardingRepository
import com.example.projectfoodtracker.domain.repositories.UserInfoRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val preferences: UserPreferencesHelper
) : UserInfoRepository {

    override fun saveUserInfo(username: String) {
        preferences.username = username
    }

    override fun getUserInfo() = preferences.username!!

    override fun isAuthorized() = preferences.isAuthorized

    override fun Authorized(boolean: Boolean) {
        preferences.isAuthorized = boolean
    }
}