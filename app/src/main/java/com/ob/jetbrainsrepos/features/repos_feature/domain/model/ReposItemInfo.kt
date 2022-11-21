package com.ob.jetbrainsrepos.features.repos_feature.domain.model

data class ReposItemInfo(
    var id: Int? = null,
    var fullName: String? = null,
    var forks: Int? = null,
    var openIssues: Int? = null,
    var watchers: Int? = null,
    var description: String? = null
)
