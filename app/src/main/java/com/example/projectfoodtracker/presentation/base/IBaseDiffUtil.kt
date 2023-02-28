package com.example.projectfoodtracker.presentation.base

interface IBaseDiffUtil<T> {
    val id: T
    override fun equals(other: Any?): Boolean
}