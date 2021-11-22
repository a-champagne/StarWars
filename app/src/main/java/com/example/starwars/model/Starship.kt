package com.example.starwars.model

import com.squareup.moshi.Json

data class Starships(
    val count: Int,
    val next: String?,
    val results: List<Starship>
)

data class Starship(
    val name: String,
    val model: String,
    val manufacturer: String,
    @Json(name = "cost_in_credits") val costInCredits: String,
    val length: String,
    @Json(name = "max_atmosphering_speed") val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    @Json(name = "cargo_capacity") val cargoCapacity: String,
    val consumables: String,
    @Json(name = "hyperdrive_rating") val hyperdriveRating: String,
    val MGLT: String,
    @Json(name = "starship_class") val starshipClass: String,
    val pilots: List<String>?,
    val films: List<String>?,
    val created: String,
    val edited: String,
    val url: String
)
