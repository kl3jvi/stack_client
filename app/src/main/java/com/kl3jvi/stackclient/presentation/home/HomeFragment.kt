package com.kl3jvi.stackclient.presentation.home

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kl3jvi.stackclient.common.NetworkUtil
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
    ): View? {
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        handleNetworkChanges()
    }
    override fun initViews() {
        binding.run {
            vm = viewModel
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
                            Log.e("LIst",state.data.toString())
                            if (state.data.isNotEmpty()) {
                                mAdapter.submitList(state.data.toMutableList())
                                showLoading(false)
                            }
                        }
                        is State.Error -> {
//                            showToast(state.message)
                            showLoading(false)
                        }
                    }
                }
            }
        }
    }

    private fun handleNetworkChanges() {
        NetworkUtil.getNetworkLiveData(requireContext()).observe(viewLifecycleOwner) { isConnected ->
            if (isConnected) {
                if (mAdapter.itemCount == 0) getUsers()
            }
        }
    }

    private fun getUsers() = viewModel.getUsers()

    private fun showLoading(isLoading: Boolean) {
        binding.swipeRefreshLayout.isRefreshing = isLoading
    }

    override fun getViewBinding(): HomeFragmentBinding = HomeFragmentBinding.inflate(layoutInflater)

}