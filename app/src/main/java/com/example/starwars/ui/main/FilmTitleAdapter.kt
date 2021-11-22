package com.example.starwars.ui.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R

import com.example.starwars.databinding.ItemViewBinding
import com.example.starwars.model.Film
import com.example.starwars.model.Films

class FilmTitleAdapter
    : ListAdapter<Film, FilmTitleAdapter.FilmTitleViewHolder>(DiffCallback) {


    class FilmTitleViewHolder(private var binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(Film: Film) {
            binding.film = Film
            binding.executePendingBindings()
        }
        val root = binding.root


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmTitleAdapter.FilmTitleViewHolder {
        return FilmTitleViewHolder(ItemViewBinding.inflate(
            LayoutInflater.from(parent.context)))
        Log.d("reached1", "____________________________________REACHED________________________________")
    }

    override fun onBindViewHolder(holder: FilmTitleViewHolder, position: Int) {
        val item = getItem(position)
        Log.d("reached", "____________________________________REACHED________________________________")

       holder.bind(item)
        val action = FilmTitleFragmentDirections.actionFilmTitleFragmentToFilmInfoFragment(item.url)
        Log.d("___ITEM URL___", item.url)
        holder.itemView.setOnClickListener(
            Navigation.createNavigateOnClickListener(action)
        )

        if (item != null) {
            Log.d("film info", item.title)
        }

    }





    companion object DiffCallback : DiffUtil.ItemCallback<Film>() {
        override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem.episodeId == newItem.episodeId
        }

    }

}