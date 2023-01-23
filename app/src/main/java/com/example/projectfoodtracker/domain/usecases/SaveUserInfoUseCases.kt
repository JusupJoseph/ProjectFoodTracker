package com.example.projectfoodtracker.domain.usecases

import com.example.projectfoodtracker.domain.repositories.UserInfoRepository
import javax.inject.Inject

class SaveUserInfoUseCases @Inject constructor(
    private val repository: UserInfoRepository
) {
    operator fun invoke(username: String){
        repository.saveUserInfo(username)
    }
}