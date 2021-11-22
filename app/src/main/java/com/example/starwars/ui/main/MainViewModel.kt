package com.example.starwars.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.starwars.api.StarWarsApi
import com.example.starwars.model.*
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel : ViewModel() {

    private val charsList = mutableListOf<Member>()

    private val filmsList = mutableListOf<Film>()
    private val peopleList = mutableListOf<Person>()
    private val vehiclesList = mutableListOf<Vehicle>()
    private val speciesList = mutableListOf<Species>()
    private val planetsList = mutableListOf<Planet>()
    private val starshipsList = mutableListOf<Starship>()

    private val _films = MutableLiveData<List<Film>>()
        var films: LiveData<List<Film>> = _films
    private val _people = MutableLiveData<List<Person>>()
        var people : LiveData<List<Person>> = _people
    private val _vehicles = MutableLiveData<List<Vehicle>>()
        var vehicles: LiveData<List<Vehicle>> = _vehicles
    private val _species = MutableLiveData<List<Species>>()
        var species: LiveData<List<Species>> = _species
    private val _planets = MutableLiveData<List<Planet>>()
        var planets: LiveData<List<Planet>> = _planets
    private val _starships = MutableLiveData<List<Starship>>()
        var starships: LiveData<List<Starship>> = _starships


    private val _filmsItem = MutableLiveData<Films>()
        var filmsItem: LiveData<Films> = _filmsItem




    private val _httpError = MutableLiveData<Boolean>()
        var httpError: LiveData<Boolean> = _httpError
    private val _filmInfo = MutableLiveData<String>()
        var filmInfo : LiveData<String> = _filmInfo
    private val _charNames = MutableLiveData<List<Member>>()
        var charNames : LiveData<List<Member>> = _charNames
    private val _planetNames = MutableLiveData<List<Member>>()
        var planetNames: LiveData<List<Member>> = _planetNames
    private val _vehicleNames = MutableLiveData<List<Member>>()
        var vehicleNames : LiveData<List<Member>> = _vehicleNames
    private val _starshipNames = MutableLiveData<List<Member>>()
        var starshipNames : LiveData<List<Member>> = _starshipNames
    private val _speciesNames = MutableLiveData<List<Member>>()
        var speciesNames : LiveData<List<Member>> = _speciesNames
    private val _currentFilm = MutableLiveData<Film>()
        var currentFilm: LiveData<Film> = _currentFilm



    init {
        getFilms()
        getPeople()
        getSpeciess()
        getPlanets()
        getStarships()
        getVehicles()

        logFilmData()
    }

    private fun getFilms(){
        viewModelScope.launch{
            try{
                var pageNum = 1
                var films = StarWarsApi.retrofitService.getFilms(pageNum++)
                filmsList.addAll(films.results)

                while (films.next != null){
                    try{
                        films = StarWarsApi.retrofitService.getFilms(pageNum++)
                        filmsList.addAll(films.results)
                    } catch (e: Exception) {
                        Log.e("error getting people", e.toString())
                    }
                }

            } catch(e:Exception) {
                Log.e("error getting people", e.toString())
            }
        }
    }

    private fun getPeople(){
        viewModelScope.launch{
            try{
                var pageNum = 1
                var people = StarWarsApi.retrofitService.getPeople(pageNum++)
                peopleList.addAll(people.results)

                while (people.next != null){
                    try{
                        people = StarWarsApi.retrofitService.getPeople(pageNum++)
                        peopleList.addAll(people.results)
                    } catch (e: Exception) {
                        Log.e("error getting people", e.toString())
                    }
                }

            } catch(e:Exception) {
                Log.e("error getting people", e.toString())
            }
        }
    }

    private fun getVehicles(){
        viewModelScope.launch{
            try{
                var pageNum = 1
                var vehicles = StarWarsApi.retrofitService.getVehicles(pageNum++)
                vehiclesList.addAll(vehicles.results)

                while (vehicles.next != null){
                    try{
                        vehicles = StarWarsApi.retrofitService.getVehicles(pageNum++)
                        vehiclesList.addAll(vehicles.results)
                    } catch (e: Exception) {
                        Log.e("error getting people", e.toString())
                    }
                }

            } catch(e:Exception) {
                Log.e("error getting people", e.toString())
            }
        }
    }

    private fun getPlanets(){
        viewModelScope.launch{
            try{
                var pageNum = 1
                var planets = StarWarsApi.retrofitService.getPlanets(pageNum++)
                planetsList.addAll(planets.results)

                while (planets.next != null){
                    try{
                        planets = StarWarsApi.retrofitService.getPlanets(pageNum++)
                        planetsList.addAll(planets.results)
                    } catch (e: Exception) {
                        Log.e("error getting people", e.toString())
                    }
                }

            } catch(e:Exception) {
                Log.e("error getting people", e.toString())
            }
        }
    }

    private fun getSpeciess(){
        viewModelScope.launch{
            try{
                var pageNum = 1
                var species = StarWarsApi.retrofitService.getSpeciess(pageNum++)
                speciesList.addAll(species.results)

                while (species.next != null){
                    try{
                        species = StarWarsApi.retrofitService.getSpeciess(pageNum++)
                        speciesList.addAll(species.results)
                    } catch (e: Exception) {
                        Log.e("error getting people", e.toString())
                    }
                }

            } catch(e:Exception) {
                Log.e("error getting people", e.toString())
            }
        }
    }

    private fun getStarships(){
        viewModelScope.launch{
            try{
                var pageNum = 1
                var starships = StarWarsApi.retrofitService.getStarships(pageNum++)
                starshipsList.addAll(starships.results)

                while (starships.next != null){
                    try{
                        starships = StarWarsApi.retrofitService.getStarships(pageNum++)
                        starshipsList.addAll(starships.results)
                    } catch (e: Exception) {
                        Log.e("error getting people", e.toString())
                    }
                }

            } catch(e:Exception) {
                Log.e("error getting people", e.toString())
            }
        }
    }

    fun getSelectedFilm(url: String)  {
        
    }


//    fun getCharNamesOfFilm(film: Film) {
//        viewModelScope.launch {
//            val peopleUrls = film.characters
//            for (url in peopleUrls) {
//                val personId = url.substring(url.length - 2, url.length - 1)
//                try {
//                    val currPerson = StarWarsApi.retrofitService.getPerson(personId.toInt())
//                    val id = UUID.randomUUID().toString()
//                    val newMemb = Member(currPerson.name, id)
//                    charsList.add(newMemb)
//                } catch (e: Exception) {
//                    Log.e("error_NOOB", e.toString())
//                }
//            }
//            _charNames.value = charsList
//        }
//    }
//
//
//    fun getFilmData() {
//        viewModelScope.launch {
//            try{
//                _filmsItem.value = StarWarsApi.retrofitService.getFilms()
//                Log.d("RAW DATA", StarWarsApi.retrofitService.getFilms().toString() )
//                logFilmData()
//               _films.value = _filmsItem.value!!.results
//                Log.d("FILMS VALUE", _films.value.toString())
//                _httpError.value = false
//            } catch (e: Exception) {
//                _httpError.value = true
//                Log.e("error", e.toString())
//            }
//        }
//    }
//
//    fun populateFilmData(id: Int){
//        viewModelScope.launch {
//            try {
//                val filmDetails = StarWarsApi.retrofitService.getFilm(id)
//                _currentFilm.value = filmDetails
//                getCharNamesOfFilm(filmDetails)
//                _filmInfo.value = filmDetails.toString()
//                Log.d("Film DATA !!!", filmDetails.toString())
//            } catch (e: Exception) {
//                Log.e("error", e.toString())
//            }
//        }
//
//    }

    fun logFilmData() {
        Log.d("film data", _films.value.toString())
    }

}


