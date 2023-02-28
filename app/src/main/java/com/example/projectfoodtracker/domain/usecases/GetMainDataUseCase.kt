package com.example.projectfoodtracker.domain.usecases

import com.example.projectfoodtracker.domain.repositories.MainRepository
import javax.inject.Inject

class GetMainDataUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    operator fun invoke() = mainRepository.getData()
}