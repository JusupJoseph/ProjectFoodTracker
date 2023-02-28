package com.example.projectfoodtracker.presentation.ui.fragments.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.projectfoodtracker.R
import com.example.projectfoodtracker.databinding.FragmentOnBoardingBinding
import com.example.projectfoodtracker.domain.models.OnBoardingModel
import com.example.projectfoodtracker.presentation.ui.adapters.OnBoardingAdapter
import com.example.projectfoodtracker.presentation.ui.fragments.inter.TransitionOnBoard
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding), TransitionOnBoard{

    private val binding by viewBinding(FragmentOnBoardingBinding::bind)
    private val list = arrayListOf<OnBoardingModel>()
    private val viewModel by viewModels<OnBoardViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewModel.getInfo()) {
            findNavController().navigate(R.id.clearBackStack)
        }

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
                R.drawable.imgfoods,
                "C возможностью",
                "просмотра съеденных вами \n продуктов",
                "GO!"
            )
        )
        binding.vpOnBoarding.adapter = OnBoardingAdapter(list, this)
        binding.dotsIndicator.attachTo(binding.vpOnBoarding)
    }

    override fun next() {
        viewModel.saveInfo(boolean = true)
        findNavController().navigate(R.id.signInFragment)
    }

    override fun transition() {
        val adapter = binding.vpOnBoarding.adapter
        val currentPosition = binding.vpOnBoarding.currentItem
        val nextPosition = currentPosition + 1
        if (nextPosition < adapter!!.itemCount) {
            binding.vpOnBoarding.currentItem = nextPosition
        }
    }
}