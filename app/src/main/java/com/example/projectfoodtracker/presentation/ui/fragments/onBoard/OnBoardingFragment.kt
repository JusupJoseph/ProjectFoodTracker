package com.example.projectfoodtracker.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.projectfoodtracker.R
import com.example.projectfoodtracker.data.local.sharedpreferences.PreferencesHelper
import com.example.projectfoodtracker.databinding.FragmentOnBoardingBinding
import com.example.projectfoodtracker.domain.models.OnBoardingModel
import com.example.projectfoodtracker.domain.repositories.OnBoardingRepository
import com.example.projectfoodtracker.presentation.ui.adapters.OnBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding){

    private val binding by viewBinding(FragmentOnBoardingBinding::bind)
    private val list = arrayListOf<OnBoardingModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.add(
            OnBoardingModel(
                R.drawable.img_one,
                "Добро пожаловать в \n" +
                        "FoodTracker  ",
                "", "Пропустить"
            )
        )
        list.add(
            OnBoardingModel(
                R.drawable.img_two, "В приложении",
                "вы регулируете количество \n поглощенных калорий.", "Пропустить"
            )
        )
        list.add(
            OnBoardingModel(
                R.drawable.img,
                "C возможностью",
                "просмотра съеденных вами \n продуктов",
                "GO!"
            )
        )
        binding.vpOnBoarding.adapter = OnBoardingAdapter(list)
        binding.dotsIndicator.attachTo(binding.vpOnBoarding)


    }

}