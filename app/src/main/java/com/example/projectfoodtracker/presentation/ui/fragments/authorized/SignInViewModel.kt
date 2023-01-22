package com.example.projectfoodtracker.presentation.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.projectfoodtracker.domain.usecases.SaveUserInfoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val saveUserInfoUseCases: SaveUserInfoUseCases,
) : ViewModel() {
    fun saveUserInfo(username: String) {
        saveUserInfoUseCases(username)
    }
}