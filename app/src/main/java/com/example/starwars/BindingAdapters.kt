package com.example.starwars

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.model.Film
import com.example.starwars.model.Member
import com.example.starwars.ui.main.CharacterMemberAdapter
import com.example.starwars.ui.main.FilmMemberAdapter
import com.example.starwars.ui.main.FilmTitleAdapter

//Home Page binding Adapters
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Film>?) {
        val adapter = recyclerView.adapter as FilmTitleAdapter
        adapter.submitList(data)
}
//Film info page binding adapters
@BindingAdapter("filmCharData")
fun bindRecyclerFilmViewChars(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as FilmMemberAdapter
        adapter.submitList(data)
}
@BindingAdapter("filmPlanetData")
fun bindRecyclerFilmViewPlanets(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as FilmMemberAdapter
        adapter.submitList(data)
}
@BindingAdapter("filmStarshipData")
fun bindRecyclerFilmViewStarships(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as FilmMemberAdapter
        adapter.submitList(data)
}

@BindingAdapter("filmSpeciesData")
fun bindRecyclerFilmViewSpecies(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as FilmMemberAdapter
        adapter.submitList(data)
}
@BindingAdapter("filmVehicleData")
fun bindRecyclerFilmViewVehicles(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as FilmMemberAdapter
        adapter.submitList(data)
}

//Character Page Binding Adapters
@BindingAdapter("charVehicleData")
fun bindRecyclerCharViewVehicles(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as CharacterMemberAdapter
        adapter.submitList(data)
}
@BindingAdapter("charStarshipData")
fun bindRecyclerCharViewStarships(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as CharacterMemberAdapter
        adapter.submitList(data)
}
@BindingAdapter("charFilmData")
fun bindRecyclerCharViewFilms(recyclerView: RecyclerView, data: List<Member>?) {
        val adapter = recyclerView.adapter as CharacterMemberAdapter
        adapter.submitList(data)
}