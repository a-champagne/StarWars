package com.example.starwars.api

import com.example.starwars.model.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val API_URL = "https://swapi.py4e.com/api"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(API_URL)
    .build()

interface StarWarsApiService{
    @GET("/films/")
    suspend fun getFilms(@Query("page") page: Int): Films

    @GET("/people/")
    suspend fun getPeople(@Query("page") page: Int): Persons

    @GET("/vehicles/")
    suspend fun getVehicles(@Query("page") page: Int): Vehicles

    @GET("/species/")
    suspend fun getSpeciess(@Query("page") page: Int): Speciess

    @GET("/planets/")
    suspend fun getPlanets(@Query("page") page: Int): Planets

    @GET("/starships/")
    suspend fun getStarships(@Query("page") page: Int): Starships

    @GET("/films/{id}/")
    suspend fun getFilm(@Path("id") id: Int): Film

    @GET("/people/{id}/")
    suspend fun getPerson(@Path("id") id: Int): Person

    @GET("/vehicles/{id}/")
    suspend fun getVehicle(@Path("id") id: Int ): Vehicle

    @GET("/species/{id}/")
    suspend fun getSpecies(@Path("id") id: Int): Species

    @GET("/planets/{id}/")
    suspend fun getPlanet(@Path("id") id : Int): Planet

    @GET("/starships/{id}/")
    suspend fun getStarship(@Path("id") id : Int): Starship

}



object StarWarsApi {
    val retrofitService : StarWarsApiService by lazy {
        retrofit.create(StarWarsApiService::class.java)
    }
}