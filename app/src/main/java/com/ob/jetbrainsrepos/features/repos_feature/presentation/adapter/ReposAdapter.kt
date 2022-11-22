package com.ob.jetbrainsrepos.features.repos_feature.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.ob.jetbrainsrepos.R
import com.ob.jetbrainsrepos.databinding.ReposListItemBinding
import com.ob.jetbrainsrepos.features.repos_feature.domain.model.RepoInfoDetails
import com.ob.jetbrainsrepos.features.repos_feature.presentation.items.RepoItemUiState
import javax.inject.Inject

class ReposAdapter @Inject constructor(
    private val itemClickListener: ReposItemClickListener
): PagingDataAdapter<RepoItemUiState, ReposViewHolder>(Comparator) {

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        getItem(position)?.let { repoItemUiState -> holder.bind(repoItemUiState, itemClickListener.clickListener) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val binding = DataBindingUtil.inflate<ReposListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.repos_list_item,
            parent,
            false
        )

        return ReposViewHolder(binding)
    }

    object Comparator : DiffUtil.ItemCallback<RepoItemUiState>() {
        override fun areItemsTheSame(oldItem: RepoItemUiState, newItem: RepoItemUiState): Boolean {
            return oldItem.reposItemInfo.id == newItem.reposItemInfo.id
        }

        override fun areContentsTheSame(
            oldItem: RepoItemUiState,
            newItem: RepoItemUiState
        ): Boolean {
            return oldItem == newItem
        }
    }
}

data class ReposItemClickListener @Inject constructor(
    val clickListener: (repoItemDetails: RepoInfoDetails) -> Unit
)