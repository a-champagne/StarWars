package com.example.starwars.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.starwars.databinding.FragmentFilmInfoBinding

class FilmInfoFragment: Fragment() {
   private val sharedViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFilmInfoBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = sharedViewModel

        binding.filmCharactersView.adapter = FilmMemberAdapter()
        binding.filmPlanetsView.adapter = FilmMemberAdapter()
        binding.filmSpeciesView.adapter = FilmMemberAdapter()
        binding.filmStarshipsView.adapter = FilmMemberAdapter()
        binding.filmVehiclesView.adapter = FilmMemberAdapter()

        val args: FilmInfoFragmentArgs by navArgs()
        sharedViewModel.setCurrentFilm(args.url)

        sharedViewModel.setCurrentPeopleNamesForFilm()
        sharedViewModel.setCurrentPlanetNamesForFilm()
        sharedViewModel.setCurrentSpeciesNamesForFilm()
        sharedViewModel.setCurrentStarshipNamesForFilm()
        sharedViewModel.setCurrentVehicleNamesForFilm()

        return binding.root
    }
}