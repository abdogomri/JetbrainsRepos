package com.ob.jetbrainsrepos.features.repos_feature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.ob.jetbrainsrepos.features.repos_feature.domain.mappers.toReposItemInfo
import com.ob.jetbrainsrepos.features.repos_feature.domain.repository.JetbrainsRepositoriesRepository
import com.ob.jetbrainsrepos.features.repos_feature.presentation.items.RepoItemUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ReposListViewModel @Inject constructor(
    private val repository: JetbrainsRepositoriesRepository,
): ViewModel(){

    lateinit var reposListUiStates: Flow<PagingData<RepoItemUiState>>

    init {
        getReposData()
    }

    private fun getReposData() {
        reposListUiStates = repository.getPagingReposInfo()
            .map { pagingData ->
                pagingData.map {
                        reposData -> RepoItemUiState(reposData.toReposItemInfo()) }
            }.cachedIn(viewModelScope)
    }
    fun onEvent(event: RepoListEvent) {
        when(event) {
            RepoListEvent.OnSwipeRefresh -> getReposData()
        }
    }

}