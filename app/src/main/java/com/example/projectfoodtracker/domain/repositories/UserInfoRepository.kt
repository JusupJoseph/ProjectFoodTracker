package com.example.projectfoodtracker.domain.repositories

interface UserInfoRepository{
    fun saveUserInfo(username: String)
    fun getUserInfo(): String
    fun isAuthorized(): Boolean
    fun Authorized(boolean: Boolean)
}