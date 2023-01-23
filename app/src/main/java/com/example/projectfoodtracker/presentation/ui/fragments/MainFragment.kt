package com.example.projectfoodtracker.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.projectfoodtracker.R
import com.example.projectfoodtracker.databinding.FragmentMainBinding
import com.example.projectfoodtracker.presentation.Counter
import com.example.projectfoodtracker.presentation.CounterNotificationService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    val service = CounterNotificationService(requireContext())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageBtn.setOnClickListener {
            service.showNotification(Counter.value)
        }
    }
}