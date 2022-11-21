package com.ob.jetbrainsrepos.di

import android.content.Context
import com.ob.jetbrainsrepos.shared.data.ApiInterfaceContainer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiProviderModule {
    @Provides
    @Singleton
    fun provideApiContainer(
        @ApplicationContext context: Context
    ): ApiInterfaceContainer {
        return ApiInterfaceContainer(context)
    }
}