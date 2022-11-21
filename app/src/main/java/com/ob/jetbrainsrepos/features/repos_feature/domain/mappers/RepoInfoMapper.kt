package com.ob.jetbrainsrepos.features.repos_feature.domain.mappers

import com.ob.jetbrainsrepos.features.repos_feature.data.remote.RepoInfo
import com.ob.jetbrainsrepos.features.repos_feature.domain.model.RepoInfoDetails
import com.ob.jetbrainsrepos.features.repos_feature.domain.model.ReposItemInfo

fun RepoInfo.toReposItemInfo(): ReposItemInfo {
    return ReposItemInfo(
        fullName = fullName,
        forks = forks,
        openIssues = openIssues,
        watchers = watchers,
        description = description
    )
}

fun ReposItemInfo.toRepoInfoDetails(): RepoInfoDetails {
    return RepoInfoDetails(
        fullName = fullName,
        description = description
    )
}