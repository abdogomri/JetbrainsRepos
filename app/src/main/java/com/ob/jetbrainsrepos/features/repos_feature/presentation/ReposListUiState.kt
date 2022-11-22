package com.ob.jetbrainsrepos.features.repos_feature.presentation

import android.content.Context
import androidx.paging.LoadState
import com.ob.jetbrainsrepos.R
import com.ob.jetbrainsrepos.shared.utils.common.BaseUiState

data class ReposListUiState(val loadState: LoadState = LoadState.Loading): BaseUiState() {
    fun getProgressBarVisibility() = getViewVisibility(isVisible = loadState is LoadState.Loading)
    fun getRefreshing()= getIsRefreshing(isRefreshing = false)
    fun getListVisibility() = getViewVisibility(isVisible = loadState is LoadState.NotLoading)

    fun getErrorVisibility() = getViewVisibility(isVisible = loadState is LoadState.Error)
    fun getErrorMessage(context: Context) = if (loadState is LoadState.Error) {
        loadState.error.localizedMessage ?: context.getString(R.string.ws_error_message)
    } else ""
}