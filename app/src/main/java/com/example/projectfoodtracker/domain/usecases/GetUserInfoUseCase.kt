package com.example.projectfoodtracker.domain.usecases

import com.example.projectfoodtracker.domain.repositories.UserInfoRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val repository: UserInfoRepository
) {
    fun invoke() = repository.getUserInfo()
}