package com.example.projectfoodtracker.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectfoodtracker.databinding.ItemOnBoardingBinding
import com.example.projectfoodtracker.domain.models.OnBoardingModel
import com.example.projectfoodtracker.presentation.ui.fragments.inter.TransitionOnBoard

class OnBoardingAdapter(
    private val list: ArrayList<OnBoardingModel>,
    private val transition: TransitionOnBoard
): RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: OnBoardingModel) {
            binding.ivOnBoarding.setImageResource(model.image)
            binding.tvTittle.text = model.tittle
            binding.tvDescription.text = model.description
            binding.btnGo.text = model.nameBtn

            if (binding.btnGo.text == "Пропустить") {
                binding.btnGo.setOnClickListener {
                    transition.transition()
                }
            } else {
                binding.btnGo.setOnClickListener {
                    transition.next()
                }
            }
        }
    }
}