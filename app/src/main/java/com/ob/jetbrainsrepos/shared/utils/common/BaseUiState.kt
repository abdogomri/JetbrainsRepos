package com.ob.jetbrainsrepos.shared.utils.common

import android.view.View

open class BaseUiState {
    fun getViewVisibility(isVisible: Boolean) = if (isVisible) View.VISIBLE else View.GONE
    fun getIsRefreshing(isRefreshing: Boolean) = isRefreshing

}