package com.example.projectfoodtracker.presentation.ui.fragments.authorized

import androidx.lifecycle.ViewModel
import com.example.projectfoodtracker.domain.usecases.AuthorizedUseCase
import com.example.projectfoodtracker.domain.usecases.SaveUserInfoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val saveUserInfoUseCases: SaveUserInfoUseCases,
    private val authorizedUseCase: AuthorizedUseCase
) : ViewModel() {
    fun saveUserInfo(username: String) {
        saveUserInfoUseCases(username)
    }

    fun authorized(boolean: Boolean) = authorizedUseCase.authorized(boolean)

    fun isAuthorized() = authorizedUseCase.isAuthorized()
}