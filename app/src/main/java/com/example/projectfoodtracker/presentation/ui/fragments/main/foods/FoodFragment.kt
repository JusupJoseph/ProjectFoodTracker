package com.example.projectfoodtracker.presentation.ui.fragments.main.foods

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.projectfoodtracker.App
import com.example.projectfoodtracker.R
import com.example.projectfoodtracker.databinding.FragmentFoodBinding
import com.example.projectfoodtracker.domain.models.FoodsModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class FoodFragment : Fragment(R.layout.fragment_food) {

    private val binding by viewBinding(FragmentFoodBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendNewFoods()
        goToBackMainFragment()
        saveButton()
    }

    private fun saveButton() = with(binding) {
      textConfirmNote.setOnClickListener {
          val title = title.text.toString()
          val calories = directions.text.toString()
          val data = getData()

          if (data.isNotEmpty() || calories.isNotEmpty()) {

              App.getDataIntense()?.getNoteDao()?.insert(
                  FoodsModel(title, calories, data )
              )
          } else {
              Toast.makeText(requireContext(), "Message mustn't empty", Toast.LENGTH_LONG).show()
          }

          findNavController().navigate(R.id.action_foodFragment_to_mainFragment)
      }
    }

    private fun sendNewFoods() = with(binding) {
        btnSave.setOnClickListener {
            val title = title.text.toString()
            val calories = directions.text.toString()
            val data = getData()

            if (data.isNotEmpty() || calories.isNotEmpty()) {

                App.getDataIntense()?.getNoteDao()?.insert(
                    FoodsModel(title, calories, data)
                )
            } else {
                Toast.makeText(requireContext(), "Message mustn't empty", Toast.LENGTH_LONG).show()
            }

            findNavController().navigate(R.id.action_foodFragment_to_notificationFragment)
        }
    }

    private fun getData(): String {
        val dataFormat = SimpleDateFormat("d MMMM")
        val data = dataFormat.format(Calendar.getInstance().time)

        return data
    }

    private fun goToBackMainFragment() = with(binding) {
        back.setOnClickListener {
            findNavController().navigate(R.id.action_foodFragment_to_mainFragment)
        }
    }
}