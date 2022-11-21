package com.ob.jetbrainsrepos.shared.data.local


import com.ob.jetbrainsrepos.features.repos_feature.data.remote.RepoInfo
import com.ob.jetbrainsrepos.shared.data.ApiInterface
import com.ob.jetbrainsrepos.shared.utils.getMock

class MockApiInterfaceImpl : ApiInterface {
    override suspend fun getJetbrainsReposInfo(page: Int): List<RepoInfo> {
        return getMock("reposInfoMock.json")
    }
}