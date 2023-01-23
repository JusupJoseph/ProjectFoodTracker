package com.example.projectfoodtracker.presentation.ui.fragments.authorized

import androidx.lifecycle.ViewModel
import com.example.projectfoodtracker.domain.usecases.GetAuthorizedInfoUseCase
import com.example.projectfoodtracker.domain.usecases.SetAuthorizedInfoUseCase
import com.example.projectfoodtracker.domain.usecases.SaveUserInfoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val saveUserInfoUseCases: SaveUserInfoUseCases,
    private val setAuthorizedUseCase: SetAuthorizedInfoUseCase,
    private val getAuthorizedUseCase: GetAuthorizedInfoUseCase
) : ViewModel() {
    fun saveUserInfo(username: String) {
        saveUserInfoUseCases(username)
    }

    fun authorized(boolean: Boolean) = setAuthorizedUseCase.authorized(boolean)

    fun isAuthorized() = getAuthorizedUseCase.isAuthorized()
}