package com.example.projectfoodtracker.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.local.sharedpreferences.onBoard.OnBoardPreferencesHelper
import com.example.cleanarchitecture.databinding.FragmentOnBoardBinding
import com.example.cleanarchitecture.domain.models.onBoarding.OnBoardingModel
import com.example.cleanarchitecture.domain.repositories.OnBoardRepository
import com.example.cleanarchitecture.presentation.ui.adapters.onBoarding.OnBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class OnBoardFragment : Fragment(), OnBoardRepository {

    private lateinit var binding: FragmentOnBoardBinding
    private val list = arrayListOf<OnBoardingModel>()

    @Inject
    lateinit var sharedPreferences: OnBoardPreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences.getPreferences(requireContext(), findNavController())

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
                "вы регулируете количество поглощенных калорий.", "Пропустить"
            )
        )
        list.add(
            OnBoardingModel(
                R.drawable.img_three,
                "C возможностью",
                "просмотра съеденных вами продуктов",
                "GO!"
            )
        )
        binding.vpOnBoarding.adapter = OnBoardingAdapter(list, this)
        binding.dotsIndicator.attachTo(binding.vpOnBoarding)


    }

    override fun next() {
        sharedPreferences.putPreferences(requireContext())
        findNavController().navigate(R.id.signIn)
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