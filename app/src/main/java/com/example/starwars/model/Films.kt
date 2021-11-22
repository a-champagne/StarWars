package com.example.starwars.model

import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class Films (
    val count: Int,
    val next: String,
    val results: List<Film>
    )



@Serializable
data class Member (
    val name: String,
    val id: String
        )