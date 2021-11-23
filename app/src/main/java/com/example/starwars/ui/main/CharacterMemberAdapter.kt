package com.example.starwars.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.databinding.MemberViewBinding
import com.example.starwars.model.Member

class CharacterMemberAdapter
    : ListAdapter<Member, CharacterMemberAdapter.CharacterMemberViewHolder>(DiffCallback){
        class CharacterMemberViewHolder(private var binding: MemberViewBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(Member: Member) {
                binding.member = Member
                binding.executePendingBindings()
            }
            val root = binding.root
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterMemberAdapter.CharacterMemberViewHolder {
            return CharacterMemberAdapter.CharacterMemberViewHolder(
                MemberViewBinding.inflate(
                    LayoutInflater.from(parent.context)
                )
            )
        }

        override fun onBindViewHolder(holder: CharacterMemberAdapter.CharacterMemberViewHolder, position: Int) {
            val item = getItem(position)
            holder.bind(item)
        }
        companion object DiffCallback : DiffUtil.ItemCallback<Member>() {
            override fun areItemsTheSame(oldItem: Member, newItem: Member): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Member, newItem: Member): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
}