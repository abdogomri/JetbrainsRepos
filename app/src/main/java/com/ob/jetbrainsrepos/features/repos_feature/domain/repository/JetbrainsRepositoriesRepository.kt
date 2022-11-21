package com.ob.jetbrainsrepos.features.repos_feature.domain.repository

import androidx.paging.PagingData
import com.ob.jetbrainsrepos.features.repos_feature.data.remote.RepoInfo
import kotlinx.coroutines.flow.Flow

interface JetbrainsRepositoriesRepository {

    fun getPagingReposInfo(): Flow<PagingData<RepoInfo>>
    suspend fun getReposInfoList(page: Int):List<RepoInfo>
}