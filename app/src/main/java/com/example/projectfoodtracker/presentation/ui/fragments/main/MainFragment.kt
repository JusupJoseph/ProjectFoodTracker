package com.example.projectfoodtracker.presentation.ui.fragments.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.projectfoodtracker.App
import com.example.projectfoodtracker.R
import com.example.projectfoodtracker.databinding.FragmentMainBinding
import com.example.projectfoodtracker.presentation.base.BaseFragment
import com.example.projectfoodtracker.presentation.models.MainModelUI
import com.example.projectfoodtracker.presentation.models.toUI
import com.example.projectfoodtracker.presentation.ui.adapters.FoodsAdapter
import com.example.projectfoodtracker.presentation.ui.adapters.OnNoteClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main),
    OnNoteClickListener {
    override val binding by viewBinding(FragmentMainBinding::bind)
    override val viewModel by viewModels<MainViewModel>()
    private val adapter: FoodsAdapter = FoodsAdapter(this)
    override fun initialize() {
        addFood()
        initializeRecycleViewAdapter()
        setShapeRecyclerView()
        getNoteAndAddToList()
        goToTheSettingFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun addFood() = with(binding) {
        addNewNote.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_foodFragment
            )
        }
    }

    // TODO: change dynamically layout item in recyclerView
    private fun initializeRecycleViewAdapter() = with(binding) {
        val isShapeRecyclerViewLinear = App.mainPreferenceData.data("data")

        if (isShapeRecyclerViewLinear) {
            recycleView.layoutManager = LinearLayoutManager(requireContext())
            adapter.isLinearLayout = true

        } else {
            adapter.isLinearLayout = false
            recycleView.layoutManager = GridLayoutManager(requireContext(), 2)
        }

        recycleView.adapter = adapter
    }

    fun setShapeRecyclerView() {
        binding.shapeRecycleView.setOnClickListener {
            val isShapeLinear = App.mainPreferenceData.data("data")

            if (!isShapeLinear) {
                binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
                App.mainPreferenceData.calories("data")
                App.mainPreferenceData.name("data")
                App.mainPreferenceData.data("data")
                App.mainPreferenceData.putValue("data", true)
                adapter.isLinearLayout = true
                adapter.notifyDataSetChanged()
                binding.shapeRecycleView.setBackgroundColor(R.drawable.layout_image)
                Toast.makeText(requireContext(), "Grid - $isShapeLinear ", Toast.LENGTH_SHORT)
                    .show()

            } else {
                binding.recycleView.layoutManager = GridLayoutManager(requireContext(), 2)
                App.mainPreferenceData.name("data")
                App.mainPreferenceData.calories("data")
                App.mainPreferenceData.putValue("data", false)
                binding.shapeRecycleView.setBackgroundResource(R.drawable.icon)
                adapter.isLinearLayout = false
                adapter.notifyDataSetChanged()
                Toast.makeText(requireContext(), "data - $isShapeLinear ", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    private fun getNoteAndAddToList() {
        App.getDataIntense()?.getNoteDao()?.getAllModels()?.observe(viewLifecycleOwner) {
            adapter.submitList(it.map { foodsModel ->
                foodsModel.toUI()
            })
        }

    }

    private fun goToTheSettingFragment() = with(binding) {
        bottomCircle.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_settingFragment
            )
        }
    }

    override fun onLongClick(model: MainModelUI) {

    }

    override fun onShortClick(model: MainModelUI) {

    }

}