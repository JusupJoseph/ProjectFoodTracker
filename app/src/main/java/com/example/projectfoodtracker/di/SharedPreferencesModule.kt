package com.example.projectfoodtracker.di

import android.content.Context
import com.example.projectfoodtracker.data.local.sharedpreferences.OnBoardPreferencesHelper
import com.example.projectfoodtracker.data.local.sharedpreferences.UserPreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideOnBoardSharedPreferences(@ApplicationContext context: Context) : OnBoardPreferencesHelper {
        return OnBoardPreferencesHelper(context)
    }

    @Provides
    @Singleton
    fun provideUserSharedPreferences(@ApplicationContext context: Context) : UserPreferencesHelper {
        return UserPreferencesHelper(context)
    }
}