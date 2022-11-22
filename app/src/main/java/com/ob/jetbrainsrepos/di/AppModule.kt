package com.ob.jetbrainsrepos.di

import com.ob.jetbrainsrepos.features.repos_feature.data.repository.JetbrainsRepositoriesRepositoryImpl
import com.ob.jetbrainsrepos.features.repos_feature.domain.repository.JetbrainsRepositoriesRepository
import com.ob.jetbrainsrepos.shared.data.ApiInterface
import com.ob.jetbrainsrepos.shared.data.ApiInterfaceContainer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class, FragmentComponent::class)
object AppModule {

    @Provides
    fun provideOnlineApiInterface(container: ApiInterfaceContainer): ApiInterface {
        return container.provideApiInterface(false)
    }

    @Provides
    fun provideJetbrainsRepositoriesRepository(
        api: ApiInterface
    ): JetbrainsRepositoriesRepository = JetbrainsRepositoriesRepositoryImpl(api)


}