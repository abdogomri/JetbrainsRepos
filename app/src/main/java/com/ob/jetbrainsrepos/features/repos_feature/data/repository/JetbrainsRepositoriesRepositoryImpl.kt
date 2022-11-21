package com.ob.jetbrainsrepos.features.repos_feature.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ob.jetbrainsrepos.features.repos_feature.data.remote.RepoInfo
import com.ob.jetbrainsrepos.features.repos_feature.domain.repository.JetbrainsRepositoriesRepository
import com.ob.jetbrainsrepos.shared.data.ApiInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JetbrainsRepositoriesRepositoryImpl @Inject constructor(
    private val api: ApiInterface
): JetbrainsRepositoriesRepository {
    override fun getPagingReposInfo(): Flow<PagingData<RepoInfo>> {
        return Pager(
            config = PagingConfig(pageSize = 20),1,pagingSourceFactory = {ReposInfoPagingDataSource(api)}
        ).flow
    }

    override suspend fun getReposInfoList(page: Int): List<RepoInfo> {
        return api.getJetbrainsReposInfo(page)
    }
}