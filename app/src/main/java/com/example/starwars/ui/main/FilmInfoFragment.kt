package com.example.starwars.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.starwars.databinding.FragmentFilmInfoBinding

class FilmInfoFragment: Fragment() {

    private val sharedViewModel: MainViewModel by activityViewModels()
    private val _binding: FragmentFilmInfoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFilmInfoBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = sharedViewModel
        //binding.filmInfo.setText()
         binding.filmCharactersView.adapter = FilmMemberAdapter()
//        binding.filmPlanetsView.adapter = FilmMemberAdapter()
//        binding.filmSpeciesView.adapter = FilmMemberAdapter()
//        binding.filmStarshipsView.adapter = FilmMemberAdapter()
//        binding.filmVehiclesView.adapter = FilmMemberAdapter()
        val args: FilmInfoFragmentArgs by navArgs()

        if (args.episodeId != null) {
            sharedViewModel.populateFilmData(args.episodeId)
        }

        if (_binding != null) {
            _binding.filmInfo.text = sharedViewModel.filmInfo.value.toString()
        }


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}