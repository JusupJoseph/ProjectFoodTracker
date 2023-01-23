package com.example.projectfoodtracker.domain.usecases

import com.example.projectfoodtracker.domain.repositories.OnBoardingRepository
import javax.inject.Inject

class SaveOnBoardInfoUseCases @Inject constructor(
    private val repository: OnBoardingRepository
) {
    fun saveInfo(boolean: Boolean) = repository.isShow(boolean)
}