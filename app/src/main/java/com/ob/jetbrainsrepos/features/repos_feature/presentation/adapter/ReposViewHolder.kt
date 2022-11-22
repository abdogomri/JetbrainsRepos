package com.ob.jetbrainsrepos.features.repos_feature.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ob.jetbrainsrepos.databinding.ReposListItemBinding
import com.ob.jetbrainsrepos.features.repos_feature.domain.mappers.toRepoInfoDetails
import com.ob.jetbrainsrepos.features.repos_feature.domain.model.RepoInfoDetails
import com.ob.jetbrainsrepos.features.repos_feature.presentation.items.RepoItemUiState
import com.ob.jetbrainsrepos.shared.utils.executeWithAction

class ReposViewHolder(private val binding: ReposListItemBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bind(repoItemUiState: RepoItemUiState, clickListener: (repoInfoDetails: RepoInfoDetails) -> Unit) {

        binding.root.setOnClickListener {
            clickListener(repoItemUiState.reposItemInfo.toRepoInfoDetails())
        }
        binding.executeWithAction {
            this.reposItem = repoItemUiState
        }
    }
}