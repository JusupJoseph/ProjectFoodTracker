package com.example.projectfoodtracker.di

import android.content.Context
import com.example.projectfoodtracker.data.local.sharedpreferences.PreferencesHelper
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
    fun provideSharedPreferences(@ApplicationContext context: Context) : PreferencesHelper {
        return PreferencesHelper(context)
    }
}