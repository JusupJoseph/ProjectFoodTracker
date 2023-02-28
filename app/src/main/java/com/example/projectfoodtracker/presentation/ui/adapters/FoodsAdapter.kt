package com.example.projectfoodtracker.presentation.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.projectfoodtracker.R
import com.example.projectfoodtracker.databinding.ItemMainBinding
import com.example.projectfoodtracker.databinding.ItemMainTowBinding
import com.example.projectfoodtracker.presentation.models.MainModelUI
import com.example.projectfoodtracker.presentation.base.BaseDiffUtilItemCallback
import kotlin.coroutines.coroutineContext


class FoodsAdapter(private val onNoteClickListener: OnNoteClickListener) :
    ListAdapter<MainModelUI, ViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

//    private var noteList: List<MainModelUI> = ArrayList()

    var isLinearLayout: Boolean = false

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    inner class FoodsViewHolder(
        private val binding: ItemMainTowBinding
    ) :
        ViewHolder(binding.root) {

        fun onBind(model: MainModelUI) = with(binding) {

            itemTitle.text = model.name.toString()
            itemDescription.text = model.calories.toString()
            tvDate.text = model.data.toString()

            itemView.setOnLongClickListener {
                onNoteClickListener.onLongClick(model)
                return@setOnLongClickListener true
            }

            itemView.setOnClickListener {
                onNoteClickListener.onShortClick(model)
            }
        }
    }

    inner class FoodsViewHolderTow(private val binding: ItemMainBinding) :

        ViewHolder(binding.root) {

        fun onBindTow(model: MainModelUI) = with(binding) {
            itemTitle.text = model.name.toString()
            itemDescription.text = model.calories
            tvDate.text = model.data.toString()

            itemView.setOnLongClickListener {
                onNoteClickListener.onLongClick(model)
                return@setOnLongClickListener true
            }

            itemView.setOnClickListener {
                onNoteClickListener.onShortClick(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            R.layout.item_main_tow -> FoodsViewHolder(
                ItemMainTowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> FoodsViewHolderTow(
                ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder.itemViewType) {
            R.layout.item_main_tow -> {
                (holder as FoodsViewHolder).onBind(getItem(position))
            }
            else -> {
                (holder as FoodsViewHolderTow).onBindTow(getItem(position))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (isLinearLayout) {
            R.layout.item_main
        } else {
            R.layout.item_main_tow
        }
    }
}

interface OnNoteClickListener {
    fun onLongClick(model: MainModelUI)
    fun onShortClick(model: MainModelUI)
}