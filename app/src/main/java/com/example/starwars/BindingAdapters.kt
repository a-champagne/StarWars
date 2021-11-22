package com.example.starwars

import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.model.Film
import com.example.starwars.model.Member
import com.example.starwars.ui.main.FilmInfoAdapter
import com.example.starwars.ui.main.FilmMemberAdapter
import com.example.starwars.ui.main.FilmTitleAdapter


@BindingAdapter("movieTitle")
        fun bindTitle(txtView: TextView, movTitle: String?){
                movTitle?.let {
                        Log.d("movieTitle", movTitle)
                        txtView.text = movTitle.toString()

                        }
                }

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Film>?) {
        val adapter = recyclerView.adapter as FilmTitleAdapter
        adapter.submitList(data)
}
@BindingAdapter("charData")
fun bindRecyclerViewChars(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as FilmMemberAdapter
        adapter.submitList(data)
}
@BindingAdapter("planetData")
fun bindRecyclerViewPlanets(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as FilmMemberAdapter
        adapter.submitList(data)
}
@BindingAdapter("starshipData")
fun bindRecyclerViewStarships(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as FilmMemberAdapter
        adapter.submitList(data)
}

@BindingAdapter("speciesData")
fun bindRecyclerViewSpecies(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as FilmMemberAdapter
        adapter.submitList(data)
}
@BindingAdapter("vehicleData")
fun bindRecyclerViewVehicles(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as FilmMemberAdapter
        adapter.submitList(data)
}