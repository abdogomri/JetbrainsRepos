package com.ob.jetbrainsrepos.features.repos_feature.presentation.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ob.jetbrainsrepos.databinding.RepoDetailsFragmentBinding
import com.ob.jetbrainsrepos.features.repos_feature.domain.model.RepoInfoDetails
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class RepoDetailsFragment : Fragment() {

    private var _binding: RepoDetailsFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var repoInfoDetails: RepoInfoDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = navArgs<RepoDetailsFragmentArgs>()
        repoInfoDetails = args.value.repoDetails
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = RepoDetailsFragmentBinding.inflate(inflater, container, false)
        binding.fullNameTxtv.text = repoInfoDetails.fullName
        binding.descriptionTxtv.text = repoInfoDetails.description
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}