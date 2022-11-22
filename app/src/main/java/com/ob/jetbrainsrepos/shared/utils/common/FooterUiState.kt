package com.ob.jetbrainsrepos.shared.utils.common

import android.content.Context
import androidx.paging.LoadState
import com.ob.jetbrainsrepos.R

data class FooterUiState(private val loadState: LoadState) : BaseUiState() {

    fun getLoadingVisibility() = getViewVisibility(isVisible = loadState is LoadState.Loading)

    fun getErrorVisibility() = getViewVisibility(isVisible = loadState is LoadState.Error)

    fun getErrorMessage(context: Context) = if (loadState is LoadState.Error) {
        loadState.error.localizedMessage ?: context.getString(R.string.ws_error_message)
    } else ""
}