package com.kl3jvi.stackclient.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.chip.Chip
import com.kl3jvi.stackclient.common.ViewUtils.hide
import com.kl3jvi.stackclient.common.ViewUtils.show
import com.kl3jvi.stackclient.databinding.DetailsFragmentBinding
import com.kl3jvi.stackclient.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<DetailsViewModel, DetailsFragmentBinding>() {

    override val viewModel: DetailsViewModel by viewModels()
    private val args: DetailsFragmentArgs by navArgs()
    private val userData get() = args.userData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun observeViewModel() {

    }

    override fun initViews() {
        binding.userData = userData
        createTags()
    }

    fun createTags() {
        userData.collectives?.forEach { collectives ->
            if (collectives.collective.tags.isNullOrEmpty()) {
                binding.noTagsDisclaimer.show()
                binding.detailsTopTagsVal.hide()
            } else {
                binding.noTagsDisclaimer.hide()
                binding.detailsTopTagsVal.show()
                collectives.collective.tags.forEach { tag ->
                    val chip = Chip(requireContext())
                    chip.text = tag
                    binding.detailsTopTagsVal.addView(chip)
                }

            }
        }

    }

    override fun getViewBinding(): DetailsFragmentBinding =
        DetailsFragmentBinding.inflate(layoutInflater)

}