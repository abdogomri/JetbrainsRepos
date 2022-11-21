package com.ob.jetbrainsrepos.shared.data


import com.ob.jetbrainsrepos.features.repos_feature.data.remote.RepoInfo
import com.ob.jetbrainsrepos.shared.utils.Constant.JETBRAINS_REPOS
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(JETBRAINS_REPOS)
    suspend fun getJetbrainsReposInfo(
        @Query("page") page: Int
    ): List<RepoInfo>
}