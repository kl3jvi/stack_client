package com.kl3jvi.stackclient.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kl3jvi.stackclient.data.model.ItemDto
import com.kl3jvi.stackclient.databinding.UserListItemBinding
import com.kl3jvi.stackclient.presentation.home.HomeFragmentDirections

class UserListAdapter : ListAdapter<ItemDto, UserListAdapter.UserViewHolder>(
    UserDiffCallback()
) {

    inner class UserViewHolder constructor(
        private val binding: UserListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.userInfo?.let { userInfo ->
                    navigateToDetails(userInfo, view)
                }
            }
        }

        private fun navigateToDetails(userDetails: ItemDto, view: View) {
            val direction =
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(userDetails)
            view.findNavController().navigate(direction)
        }

        fun bindUserItem(item: ItemDto) {
            binding.apply {
                userInfo = item
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: UserListItemBinding = UserListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bindUserItem(getItem(position))
}

private class UserDiffCallback : DiffUtil.ItemCallback<ItemDto>() {

    override fun areItemsTheSame(
        oldItem: ItemDto,
        newItem: ItemDto
    ): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(
        oldItem: ItemDto,
        newItem: ItemDto
    ): Boolean {
        return oldItem == newItem
    }
}
