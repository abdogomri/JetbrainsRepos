package com.ob.jetbrainsrepos.features.repos_feature.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.ob.jetbrainsrepos.R
import com.ob.jetbrainsrepos.databinding.ReposListFragmentBinding
import com.ob.jetbrainsrepos.features.repos_feature.presentation.adapter.ReposAdapter
import com.ob.jetbrainsrepos.features.repos_feature.presentation.adapter.ReposItemClickListener
import com.ob.jetbrainsrepos.features.repos_feature.presentation.items.RepoItemUiState
import com.ob.jetbrainsrepos.shared.utils.collect
import com.ob.jetbrainsrepos.shared.utils.collectLast
import com.ob.jetbrainsrepos.shared.utils.common.FooterAdapter
import com.ob.jetbrainsrepos.shared.utils.executeWithAction
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

@AndroidEntryPoint
class ReposListFragment : Fragment() {
    private lateinit var reposListFragmentBinding: ReposListFragmentBinding
    lateinit var reposAdapter: ReposAdapter
    private val reposListViewModel: ReposListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        reposListFragmentBinding = DataBindingUtil.inflate<ReposListFragmentBinding?>(
            inflater,R.layout.repos_list_fragment,container,false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        setAdapter()
        collectLast(reposListViewModel.reposListUiStates, ::setReposList)

        reposListFragmentBinding.swipeContainer.setOnRefreshListener {
            lifecycleScope.launch {
                reposListViewModel.onEvent(RepoListEvent.OnSwipeRefresh)
                collectLast(
                    reposListViewModel.reposListUiStates,
                    ::setReposList
                )
            }
        }
        return reposListFragmentBinding.root

    }

    private fun setAdapter() {
        reposAdapter = ReposAdapter(itemClickListener = ReposItemClickListener {
            val action = ReposListFragmentDirections.actionShowDetails(it)
            findNavController().navigate(action)
        })

        collect(flow = reposAdapter.loadStateFlow
            .distinctUntilChangedBy { it.source.refresh }
            .map { it.refresh },
            action = ::setReposListUiState
        )
        reposListFragmentBinding.reposlist.adapter =
            reposAdapter.withLoadStateFooter(FooterAdapter(reposAdapter::retry))
    }

    private fun setReposListUiState(loadState: LoadState) {
        reposListFragmentBinding.executeWithAction {
            reposListUiState = ReposListUiState(loadState)

        }
    }

    private suspend fun setReposList(reposListPagingData: PagingData<RepoItemUiState>) {
        reposAdapter.submitData(reposListPagingData)
    }
}