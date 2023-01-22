package com.example.cleanarchitecture.domain.repositories

interface OnBoardRepository {
    fun next()
    fun transition()
}