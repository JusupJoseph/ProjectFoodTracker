package com.example.projectfoodtracker.presentation.ui.utils

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.projectfoodtracker.R
import com.google.android.material.appbar.MaterialToolbar

class ImageBehavior() : CoordinatorLayout.Behavior<ProgressBar>() {

    constructor(ctx: Context, attrs: AttributeSet) : this()

    private val MIN_AVATAR_PERCENTAGE_SIZE = 0.3f
        private val EXTRA_FINAL_AVATAR_PADDING = 80

    private val TAG = "behavior"
    private var mContext: Context? = null

    private var mCustomFinalYPosition = 0f
    private var mCustomTopXPosition = 0f
    private var mCustomTopToolbarPosition = 0f
    private var mCustomStartHeight = 0f
    private var mCustomFinalHeight = 0f

    private var mAvatarMaxSize = 0f
    private var mFinalLeftAvatarPadding = 0f
    private val mStartPosition = 0f
    private var mTopXPosition = 0
    private var mTopToolbarPosition = 0f
    private var mTopYPosition = 0
    private var mFinalYPosition = 0
    private var mTopHeight = 0
    private var mFinalXPosition = 0
    private var mChangeBehaviorPoint = 0f

    fun AvatarImageBehavior(context: Context, attrs: AttributeSet?) {
        mContext = context
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.ImageBehavior)
            mCustomFinalYPosition =
                a.getDimension(R.styleable.ImageBehavior_finalYPosition, 0f)
            mCustomTopXPosition =
                a.getDimension(R.styleable.ImageBehavior_topXPosition, 0f)
            mCustomTopToolbarPosition =
                a.getDimension(R.styleable.ImageBehavior_topToolbarPosition, 0f)
            mCustomStartHeight = a.getDimension(R.styleable.ImageBehavior_topHeight, 0f)
            mCustomFinalHeight = a.getDimension(R.styleable.ImageBehavior_finalHeight, 0f)
            a.recycle()
        }
        init()
        mFinalLeftAvatarPadding = context.resources.getDimension(
            R.dimen.spacing_normal
        )
    }

    private fun init() {
        bindDimensions()
    }

    private fun bindDimensions() {
        mAvatarMaxSize = mContext!!.resources.getDimension(R.dimen.image_width)
    }

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: ProgressBar,
        dependency: View
    ): Boolean {
        return dependency is MaterialToolbar
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: ProgressBar,
        dependency: View
    ): Boolean {
        maybeInitProperties(child, dependency)
        val maxScrollDistance = mTopToolbarPosition.toInt()
        val expandedPercentageFactor = dependency.y / maxScrollDistance
        if (expandedPercentageFactor < mChangeBehaviorPoint) {
            val heightFactor =
                (mChangeBehaviorPoint - expandedPercentageFactor) / mChangeBehaviorPoint
            val distanceXToSubtract = ((mTopXPosition - mFinalXPosition)
                    * heightFactor) + child.height / 2
            val distanceYToSubtract = ((mTopYPosition - mFinalYPosition)
                    * (1f - expandedPercentageFactor)) + child.height / 2
            child.x = mTopXPosition - distanceXToSubtract
            child.y = mTopYPosition - distanceYToSubtract
            val heightToSubtract = (mTopHeight - mCustomFinalHeight) * heightFactor
            val lp = child.layoutParams as CoordinatorLayout.LayoutParams
            lp.width = (mTopHeight - heightToSubtract).toInt()
            lp.height = (mTopHeight - heightToSubtract).toInt()
            child.layoutParams = lp
            dependency as MaterialToolbar
            if (lp.height == 0) dependency.setTitleTextColor(Color.WHITE)
            else dependency.setTitleTextColor(Color.parseColor("#161A20"))
        } else {
            val distanceYToSubtract = ((mTopYPosition - mFinalYPosition)
                    * (1f - expandedPercentageFactor)) + mTopHeight / 2
            child.x = (mTopXPosition - child.width / 2).toFloat()
            child.y = mTopYPosition - distanceYToSubtract
            val lp = child.layoutParams as CoordinatorLayout.LayoutParams
            lp.width = mTopHeight
            lp.height = mTopHeight
            child.layoutParams = lp
        }
        return true
    }

    private fun maybeInitProperties(child: ProgressBar, dependency: View) {
        if (mTopYPosition == 0) mTopYPosition = dependency.y.toInt()
        if (mFinalYPosition == 0) mFinalYPosition = dependency.height / 2
        if (mTopHeight == 0) mTopHeight = child.height
        if (mTopXPosition == 0) mTopXPosition = (child.x + child.width / 2).toInt()
        mContext?.resources?.getDimensionPixelOffset(androidx.appcompat.R.dimen.abc_action_bar_content_inset_material)
            ?.let {
                if (mFinalXPosition == 0) mFinalXPosition =
                    it + mCustomFinalHeight.toInt() / 2
            }
        if (mTopToolbarPosition == 0f) mTopToolbarPosition = dependency.y
        if (mChangeBehaviorPoint == 0f) {
            mChangeBehaviorPoint =
                (child.height - mCustomFinalHeight) / (2f * (mTopYPosition - mFinalYPosition))
        }
    }
}