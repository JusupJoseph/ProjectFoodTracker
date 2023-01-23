package com.example.projectfoodtracker.domain.usecases

import com.example.projectfoodtracker.domain.repositories.UserInfoRepository
import javax.inject.Inject

class GetAuthorizedInfoUseCase @Inject constructor(
    private val repository: UserInfoRepository
) {
    fun isAuthorized() = repository.isAuthorized()
}