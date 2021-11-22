package com.example.starwars.ui.main

import android.util.Log
import androidx.lifecycle.*

import com.example.starwars.api.StarWarsApi
import com.example.starwars.model.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.reflect.Member
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel(private val state: SavedStateHandle) : ViewModel() {

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

    private val _filmUrlMap = MutableLiveData<MutableMap<String, Film>>()
        var filmUrlMap: LiveData<MutableMap<String, Film>> = _filmUrlMap
    private val _personUrlMap = MutableLiveData<MutableMap<String, Person>>()
        var personUrlMap: LiveData<MutableMap<String, Person>> = _personUrlMap
    private val _vehicleUrlMap = MutableLiveData<MutableMap<String, Vehicle>>()
         var vehicleUrlMap: LiveData<MutableMap<String, Vehicle>> = _vehicleUrlMap
    private val _speciesUrlMap = MutableLiveData<MutableMap<String, Species>>()
         var speciesUrlMap: LiveData<MutableMap<String, Species>> = _speciesUrlMap
    private val _planetUrlMap = MutableLiveData<MutableMap<String, Planet>>()
        var planetUrlMap: LiveData<MutableMap<String, Planet>> = _planetUrlMap
    private val _starshipUrlMap = MutableLiveData<MutableMap<String, Starship>>()
        var starshipUrlMap: LiveData<MutableMap<String, Starship>> = _starshipUrlMap

    private val _currentFilm = MutableLiveData<Film>()
        var currentFilm: LiveData<Film> = _currentFilm
    private val _currentPerson = MutableLiveData<Person>()
    var currentPerson: LiveData<Person> = _currentPerson
    private val _currentPlanet = MutableLiveData<Planet>()
    var currentPlanet: LiveData<Planet> = _currentPlanet


    private val _currentPeopleNames = MutableLiveData<List<String>>()
        var currentPeopleNames: LiveData<List<String>> = _currentPeopleNames
    private val _currentVehicleNames = MutableLiveData<List<String>>()
        var currentVehicleNames: LiveData<List<String>> = _currentVehicleNames
    private val _currentSpeciesNames = MutableLiveData<List<String>>()
        var currentSpeciesNames: LiveData<List<String>> = _currentSpeciesNames
    private val _currentPlanetNames = MutableLiveData<List<String>>()
        var currentPlanetNames: LiveData<List<String>> = _currentPlanetNames
    private val _currentStarshipNames = MutableLiveData<List<String>>()
        var currentStarshipNames: LiveData<List<String>> = _currentStarshipNames
    private val _currentFilmNames = MutableLiveData<List<String>>()
        var currentFilmNames: LiveData<List<String >> =  _currentFilmNames

    private val _filmsItem = MutableLiveData<Films>()
        var filmsItem: LiveData<Films> = _filmsItem

    private val _httpError = MutableLiveData<Boolean>()
        var httpError: LiveData<Boolean> = _httpError
    private val _filmInfo = MutableLiveData<String>()
        var filmInfo : LiveData<String> = _filmInfo

    init {
       getApiData()

    }

    private fun getApiData() {
            getFilms()
            getPeople()
            getSpeciess()
            getPlanets()
            getStarships()
            getVehicles()
    }

    private fun getFilms(){
        viewModelScope.launch {
            try {
                var pageNum = 1
                var films = StarWarsApi.retrofitService.getFilms(pageNum++)
                filmsList.addAll(films.results)

                while (films.next != null) {
                    try {
                        films = StarWarsApi.retrofitService.getFilms(pageNum++)
                        filmsList.addAll(films.results)
                    } catch (e: Exception) {
                        Log.e("error getting films", e.toString())
                    }
                }
            } catch (e: Exception) {
                Log.e("error getting films", e.toString())
            }
            _films.value = filmsList
            populateFilmMap()
        }
    }

    private fun getPeople(){
        viewModelScope.launch {
            try {
                var pageNum = 1
                var people = StarWarsApi.retrofitService.getPeople(pageNum++)
                peopleList.addAll(people.results)

                while (people.next != null) {
                    try {
                        people = StarWarsApi.retrofitService.getPeople(pageNum++)
                        peopleList.addAll(people.results)
                    } catch (e: Exception) {
                        Log.e("error getting people", e.toString())
                    }
                }
            } catch (e: Exception) {
                Log.e("error getting people", e.toString())
            }
            _people.value = peopleList
            populatePeopleMap()
        }
    }

    private fun getVehicles(){
        viewModelScope.launch {
            try {
                var pageNum = 1
                var vehicles = StarWarsApi.retrofitService.getVehicles(pageNum++)
                vehiclesList.addAll(vehicles.results)

                while (vehicles.next != null) {
                    try {
                        vehicles = StarWarsApi.retrofitService.getVehicles(pageNum++)
                        vehiclesList.addAll(vehicles.results)
                    } catch (e: Exception) {
                        Log.e("error getting vehicles", e.toString())
                    }
                }
            } catch (e: Exception) {
                Log.e("error getting vehicles", e.toString())
            }
            _vehicles.value = vehiclesList
            populateVehicleMap()
        }
    }

    private fun getPlanets(){
        viewModelScope.launch {
            try {
                var pageNum = 1
                var planets = StarWarsApi.retrofitService.getPlanets(pageNum++)
                planetsList.addAll(planets.results)

                while (planets.next != null) {
                    try {
                        planets = StarWarsApi.retrofitService.getPlanets(pageNum++)
                        planetsList.addAll(planets.results)
                    } catch (e: Exception) {
                        Log.e("error getting planets", e.toString())
                    }
                }
            } catch (e: Exception) {
                Log.e("error getting planets", e.toString())
            }
           _planets.value = planetsList
            populatePlanetMap()
        }
    }

    private  fun getSpeciess(){
        viewModelScope.launch {
            try {
                var pageNum = 1
                var species = StarWarsApi.retrofitService.getSpeciess(pageNum++)
                speciesList.addAll(species.results)

                while (species.next != null) {
                    try {
                        species = StarWarsApi.retrofitService.getSpeciess(pageNum++)
                        speciesList.addAll(species.results)
                    } catch (e: Exception) {
                        Log.e("error getting species", e.toString())
                    }
                }
            } catch (e: Exception) {
                Log.e("error getting species", e.toString())
            }
            _species.value = speciesList
            populateSpeciesMap()
        }
    }

    private fun getStarships(){
        viewModelScope.launch {
            try {
                var pageNum = 1
                var starships = StarWarsApi.retrofitService.getStarships(pageNum++)
                starshipsList.addAll(starships.results)

                while (starships.next != null) {
                    try {
                        starships = StarWarsApi.retrofitService.getStarships(pageNum++)
                        starshipsList.addAll(starships.results)
                    } catch (e: Exception) {
                        Log.e("error getting starships", e.toString())
                    }
                }
            } catch (e: Exception) {
                Log.e("error getting starships", e.toString())
            }
           _starships.value = starshipsList
            populateStarshipMap()
        }
    }


   private  fun populateFilmMap() {
        val map = mutableMapOf<String, Film>()
        for(film in _films.value ?: return) {
            map[film.url] = film
            }
        _filmUrlMap.value = map
   }

    private fun populatePeopleMap() {
        val map = mutableMapOf<String, Person>()
        for(person in _people.value ?: return) {
            map[person.url] = person
        }
        _personUrlMap.value = map
    }

    private fun populateVehicleMap() {
        val map = mutableMapOf<String, Vehicle>()
        for(vehicle in _vehicles.value ?: return) {
            map[vehicle.url] = vehicle
        }
        _vehicleUrlMap.value = map
    }

    private fun populateSpeciesMap() {
        val map = mutableMapOf<String, Species>()
        for (species in _species.value ?: return){
            map[species.url] = species
        }
        _speciesUrlMap.value = map
    }

    private fun populatePlanetMap() {
        val map = mutableMapOf<String, Planet>()
        for(planet in _planets.value ?: return) {
            map[planet.url] = planet
        }
        _planetUrlMap.value = map
    }

    private fun populateStarshipMap() {
        val map = mutableMapOf<String,Starship>()
        for(starship in _starships.value ?: return){
            map[starship.url] = starship
        }
        _starshipUrlMap.value = map
    }

    fun setCurrentFilm(url: String){
        val film = filmUrlMap.value!![url]
        _currentFilm.value = film!!
        Log.d("_____currFilm____________________", _currentFilm.value.toString())
    }

    fun setCurrentPerson(url:String) {
        val person = personUrlMap.value!![url]
        _currentPerson.value = person!!
    }

    fun setCurrentPlanet(url: String) {
        val planet = planetUrlMap.value!![url]
        _currentPlanet.value = planet!!
    }

    fun setCurrentFilmNamesForCharacter() {
        val list = mutableListOf<String>()
        for(url in currentPerson.value?.films!!) {
            filmUrlMap.value?.get(url)?.let { list.add(it.title) }
        }
    }

    fun setCurrentPeopleNames() {
        val list = mutableListOf<String>()
        for(url in currentFilm.value?.characters!!){
            personUrlMap.value?.get(url)?.let { list.add(it.name) }
        }
        _currentPeopleNames.value = list
        Log.d("_CURR PPL ________", _currentPeopleNames.value.toString())
    }

    fun setCurrentVehicleNamesForFilm() {
        val list = mutableListOf<String>()
        for(url in currentFilm.value?.vehicles!!){
            vehicleUrlMap.value?.get(url)?.let { list.add(it.name) }
        }
        _currentVehicleNames.value = list
        Log.d("current VEHICLES", _currentVehicleNames.value.toString())
    }

    fun setCurrentStarshipNamesForFilm() {
        val list = mutableListOf<String>()
        for(url in currentFilm.value?.starships!!){
            starshipUrlMap.value?.get(url)?.let { list.add(it.name) }
        }
        _currentStarshipNames.value = list
    }
    fun setCurrentSpeciesNamesForFilm() {
        val list = mutableListOf<String>()
        for(url in currentFilm.value?.species!!){
            speciesUrlMap.value?.get(url)?.let { list.add(it.name) }
        }
        _currentSpeciesNames.value = list
    }
    fun setCurrentPlanetNamesForFilm() {
        val list = mutableListOf<String>()
        for(url in currentFilm.value?.planets!!){
            planetUrlMap.value?.get(url)?.let { list.add(it.name) }
        }
        _currentPlanetNames.value = list
    }

}


