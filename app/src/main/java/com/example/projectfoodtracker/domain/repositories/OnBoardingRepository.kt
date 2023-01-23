package com.example.projectfoodtracker.domain.repositories

interface OnBoardingRepository {
    fun isShow(boolean: Boolean)
    fun getInfo(): Boolean
}

