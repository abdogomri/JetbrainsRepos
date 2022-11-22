package com.ob.jetbrainsrepos.features.repos_feature.presentation

sealed class RepoListEvent {
    object OnSwipeRefresh: RepoListEvent()
}
