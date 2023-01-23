package com.example.projectfoodtracker.di

import com.example.projectfoodtracker.data.repositories.RepositoriesImpl
import com.example.projectfoodtracker.domain.repositories.OnBoardingRepository
import com.example.projectfoodtracker.domain.repositories.UserInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindUserRepository(repositoriesImpl: RepositoriesImpl): UserInfoRepository

    @Binds
    fun bindOnBoardRepository(repositoriesImpl: RepositoriesImpl): OnBoardingRepository
}