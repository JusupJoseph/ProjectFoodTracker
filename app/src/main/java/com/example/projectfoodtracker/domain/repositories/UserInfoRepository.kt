package com.example.projectfoodtracker.domain.repositories

interface UserRepository{
    fun saveUser(username: String)
    fun getUser(): String
}