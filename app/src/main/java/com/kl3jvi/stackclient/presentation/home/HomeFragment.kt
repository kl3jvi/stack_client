package com.kl3jvi.stackclient.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kl3jvi.stackclient.common.ViewUtils.showToast
import com.kl3jvi.stackclient.databinding.HomeFragmentBinding
import com.kl3jvi.stackclient.domain.model.State
import com.kl3jvi.stackclient.presentation.adapter.UserListAdapter
import com.kl3jvi.stackclient.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>() {

    override val viewModel: HomeViewModel by viewModels()
    private val mAdapter = UserListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun initViews() {
        binding.run {
//            vm = viewModel
            recyclerView.adapter = mAdapter
            swipeRefreshLayout.setOnRefreshListener { getUsers() }
        }
    }

    override fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.users.collect { state ->
                    when (state) {
                        is State.Loading -> showLoading(true)
                        is State.Success -> {
                            if (state.data.isNotEmpty()) {
                                mAdapter.submitList(state.data.toMutableList())
                                showLoading(false)
                            }
                        }
                        is State.Error -> {
                            showToast(state.message)
                            showLoading(false)
                        }
                    }
                }
            }
        }
    }

    private fun getUsers() = viewModel.getUsers()

    private fun showLoading(isLoading: Boolean) {
        binding.swipeRefreshLayout.isRefreshing = isLoading
    }

    override fun getViewBinding(): HomeFragmentBinding =
        HomeFragmentBinding.inflate(layoutInflater)
}