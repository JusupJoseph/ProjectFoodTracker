package com.example.projectfoodtracker.presentation.ui.fragments.main.foods

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.projectfoodtracker.R
import com.example.projectfoodtracker.databinding.FragmentSettingBinding
import com.example.projectfoodtracker.domain.models.FoodsModel
import com.example.projectfoodtracker.domain.models.MaxInDayCalories
import com.example.projectfoodtracker.presentation.models.MainModelUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment(R.layout.fragment_setting) {

    private val binding by viewBinding(FragmentSettingBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transitionFragment()
    }

    private fun transitionFragment() {
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
        binding.textConfirmNote.setOnClickListener {
            MaxInDayCalories(binding.title.text.toString().toInt())
            findNavController().navigate(R.id.mainFragment)
        }
        binding.success.setOnClickListener {
            MaxInDayCalories(binding.title.text.toString().toInt())
            findNavController().navigate(R.id.mainFragment)
        }

    }


}