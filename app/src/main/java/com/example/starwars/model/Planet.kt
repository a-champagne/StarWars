package com.example.starwars.model

import com.squareup.moshi.Json

data class Planets(
    val count: Int,
    val next: String?,
    val results: List<Planet>
)

data class Planet(
    val name: String,
    @Json(name = "orbital_period") val orbitalPeriod: String,
    @Json(name = "rotation_period") val rotationPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    @Json(name = "surface_water") val surfaceWater: String,
    val population: String?,
    val residents: List<String>?,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String
){
    override fun toString(): String{
        return "Name: \n" +
                "${this.name} \n\n"+
                "Rotation Period: \n" +
                "${this.rotationPeriod} \n\n"+
                "Orbital Period: \n" +
                "${this.orbitalPeriod} \n\n"+
                "Diameter: \n" +
                "${this.diameter} km \n\n"+
                "Climate: \n" +
                "${this.climate} \n\n"+
                "Gravity: \n" +
                "${this.gravity} \n\n"+
                "Terrain: \n" +
                "${this.terrain} \n\n"+
                "Surface Water: \n" +
                "${this.surfaceWater} \n\n"+
                "Population: \n" +
                "${this.population} \n\n"
    }
}
