package com.ob.jetbrainsrepos.features.repos_feature.presentation.items

import com.ob.jetbrainsrepos.features.repos_feature.domain.model.ReposItemInfo
import com.ob.jetbrainsrepos.shared.utils.common.BaseUiState

data class RepoItemUiState(
    val reposItemInfo: ReposItemInfo
): BaseUiState()