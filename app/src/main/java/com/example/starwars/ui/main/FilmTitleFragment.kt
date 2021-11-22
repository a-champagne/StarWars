package com.example.starwars.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R

import com.example.starwars.databinding.FragmentFilmTitleBinding


class FilmTitleFragment : Fragment() {

//    companion object {
//        fun newInstance() = FilmTitleFragment()
//    }
    private val _binding : FragmentFilmTitleBinding? = null
    private val sharedViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       val binding = FragmentFilmTitleBinding.inflate(inflater)
      binding.lifecycleOwner = this
        binding.viewModel = sharedViewModel
       binding.titlesView.adapter = FilmTitleAdapter()

        Log.d("reached2", "____________________________________REACHED________________________________")


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        _binding?.apply {
//            lifecycleOwner = viewLifecycleOwner
//            viewModel = sharedViewModel
//            filmTitleFragment = this@FilmTitleFragment
//        }
    }

//    fun goToNextScreen(episodeId:Int){
//
//
//        val action = FilmTitleFragmentDirections.actionFilmTitleFragmentToFilmInfoFragment(episodeId)
//        Log.d("GOING TO NEXT FRAGMENT", "TRUE")
//        //findNavController().navigate(action)
//
//    }

}