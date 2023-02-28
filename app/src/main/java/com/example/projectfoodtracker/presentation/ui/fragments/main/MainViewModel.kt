package com.example.projectfoodtracker.presentation.ui.fragments.main

import androidx.lifecycle.ViewModel
import com.example.projectfoodtracker.domain.usecases.GetMainDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val mainDataUseCase: GetMainDataUseCase
) : ViewModel() {
fun getData() = mainDataUseCase
}