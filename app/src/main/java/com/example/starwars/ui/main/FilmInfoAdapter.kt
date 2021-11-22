package com.example.starwars.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.RecyclerView

import com.example.starwars.databinding.SideScrollViewBinding
import com.example.starwars.model.Film
import com.example.starwars.model.Member

class FilmInfoAdapter
    : ListAdapter<Member, FilmInfoAdapter.FilmInfoViewHolder>(DiffCallback) {


    class FilmInfoViewHolder(private var binding:SideScrollViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(Member: Member) {
            binding.member= Member

            binding.executePendingBindings()
        }
        val root = binding.root


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmInfoAdapter.FilmInfoViewHolder {
        return FilmInfoViewHolder(
            SideScrollViewBinding.inflate(
            LayoutInflater.from(parent.context)))
        Log.d("reached1", "____________________________________REACHED________________________________")
    }

    override fun onBindViewHolder(holder: FilmInfoAdapter.FilmInfoViewHolder, position: Int) {
        val item = getItem(position)
        Log.d("reached", "____________________________________REACHED________________________________")

        holder.bind(item)

        if (item != null) {
            Log.d("film info", item.name)
        }

    }




    companion object DiffCallback : DiffUtil.ItemCallback<Member>() {
        override fun areItemsTheSame(oldItem: Member, newItem: Member): Boolean {
                return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Member, newItem: Member): Boolean {
            return oldItem.name == newItem.name
        }

    }

}