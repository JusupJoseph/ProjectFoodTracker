package com.example.projectfoodtracker.data.repositories

import com.example.projectfoodtracker.data.local.sharedpreferences.PreferencesHelper
import com.example.projectfoodtracker.domain.repositories.OnBoardingRepository
import com.example.projectfoodtracker.domain.repositories.UserInfoRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val preferences: PreferencesHelper
) : UserInfoRepository{

    override fun next() {
        preferences.isShow = true
    }
    override fun transition() {
    }

    override fun onBoardInfo(image: Int, tittle: String, description: String, nameBtn: String) {

    }

    override fun saveUserInfo(username: String) {
        preferences.username = username
    }

    override fun getUserInfo() = preferences.username!!
}