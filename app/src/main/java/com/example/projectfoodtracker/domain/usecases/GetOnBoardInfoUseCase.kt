package com.example.projectfoodtracker.domain.usecases

import com.example.projectfoodtracker.domain.repositories.OnBoardingRepository
import javax.inject.Inject

class GetOnBoardInfoUseCase @Inject constructor(
    private val repository: OnBoardingRepository
) {
    fun getBoolean() = repository.getInfo()
}