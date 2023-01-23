package com.example.projectfoodtracker.presentation.ui.fragments.onBoard

import androidx.lifecycle.ViewModel
import com.example.projectfoodtracker.domain.usecases.GetOnBoardInfoUseCase
import com.example.projectfoodtracker.domain.usecases.SaveOnBoardInfoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(
    private val saveOnBoardInfoUseCases: SaveOnBoardInfoUseCases,
    private val getOnBoardInfoUseCase: GetOnBoardInfoUseCase
): ViewModel() {
    fun saveInfo(boolean: Boolean) = saveOnBoardInfoUseCases.saveInfo(boolean)
    fun getInfo() = getOnBoardInfoUseCase.getBoolean()
}