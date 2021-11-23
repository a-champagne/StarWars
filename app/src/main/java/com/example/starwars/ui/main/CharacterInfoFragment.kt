package com.example.starwars.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.starwars.databinding.FragmentCharacterInfoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CharacterInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharacterInfoFragment : Fragment() {
        private val sharedViewModel: MainViewModel by activityViewModels()

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val binding = FragmentCharacterInfoBinding.inflate(inflater)
            binding.lifecycleOwner = viewLifecycleOwner
            binding.viewModel = sharedViewModel

            binding.charFilmsView.adapter = CharacterMemberAdapter()
            binding.charStarshipsView.adapter = CharacterMemberAdapter()
            binding.charVehiclesView.adapter = CharacterMemberAdapter()

            val args: CharacterInfoFragmentArgs by navArgs()
            sharedViewModel.setCurrentPerson(args.url)

            sharedViewModel.setCurrentFilmNamesForCharacter()
            sharedViewModel.setCurrentStarshipNamesForCharacter()
            sharedViewModel.setCurrentVehicleNamesForCharacter()

            return binding.root
        }
    }

