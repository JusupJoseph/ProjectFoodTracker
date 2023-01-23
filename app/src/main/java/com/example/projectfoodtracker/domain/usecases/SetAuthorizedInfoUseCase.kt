package com.example.projectfoodtracker.domain.usecases

import com.example.projectfoodtracker.domain.repositories.UserInfoRepository
import javax.inject.Inject

class SetAuthorizedInfoUseCase @Inject constructor(
    private val repository: UserInfoRepository
) {
    fun authorized(boolean: Boolean) = repository.Authorized(boolean)
}