package com.ob.jetbrainsrepos.shared.utils.common

import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.ob.jetbrainsrepos.databinding.ItemPagingFooterBinding
import com.ob.jetbrainsrepos.shared.utils.executeWithAction

class FooterViewHolder(
    private val binding: ItemPagingFooterBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.btnRetry.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) {
        binding.executeWithAction {
            footerUiState = FooterUiState(loadState)
        }
    }
}