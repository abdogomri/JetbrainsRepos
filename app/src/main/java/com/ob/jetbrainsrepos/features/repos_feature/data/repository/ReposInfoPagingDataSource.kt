package com.ob.jetbrainsrepos.features.repos_feature.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ob.jetbrainsrepos.features.repos_feature.data.remote.RepoInfo
import com.ob.jetbrainsrepos.shared.data.ApiInterface

class ReposInfoPagingDataSource(private val api: ApiInterface):
    PagingSource<Int, RepoInfo>() {
    override fun getRefreshKey(state: PagingState<Int, RepoInfo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RepoInfo> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {

            val response = api.getJetbrainsReposInfo(page)
            LoadResult.Page(
                data = response,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}