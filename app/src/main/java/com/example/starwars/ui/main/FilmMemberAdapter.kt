package com.example.starwars.ui.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.databinding.InfoViewBinding

import com.example.starwars.databinding.ItemViewBinding
import com.example.starwars.databinding.MemberViewBinding
import com.example.starwars.model.Film
import com.example.starwars.model.Films
import com.example.starwars.model.Member

class FilmMemberAdapter
    : ListAdapter<Member, FilmMemberAdapter.FilmMemberViewHolder>(DiffCallback) {


    class FilmMemberViewHolder(private var binding: MemberViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(Member: Member) {
            binding.member = Member
            binding.executePendingBindings()
        }
        val root = binding.root


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmMemberAdapter.FilmMemberViewHolder {
        return FilmMemberAdapter.FilmMemberViewHolder(
            MemberViewBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )

        Log.d("reached1", "____________________________________REACHED________________________________")
    }

    override fun onBindViewHolder(holder: FilmMemberAdapter.FilmMemberViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)


        if (item != null) {
            Log.d("film info", item.name + item.id)
        }

    }




    companion object DiffCallback : DiffUtil.ItemCallback<Member>() {
        override fun areItemsTheSame(oldItem: Member, newItem: Member): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Member, newItem: Member): Boolean {
            return oldItem.id == newItem.id
        }

    }

}