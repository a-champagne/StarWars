package com.example.starwars.model

import android.provider.Contacts
import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

data class Member (
    val name: String,
    val url: String,
    val type: String
        )

data class Films (
    val count: Int,
    val next: String?,
    val results: List<Film>
)

data class Film(
    val title: String,
    @Json(name = "episode_id") val episodeId: Int,
    @Json(name = "opening_crawl") val openingCrawl: String,
    val director: String,
    val producer: String,
    @Json(name = "release_date") val releaseDate: String,
    val characters: List<String>,
    val planets: List<String>,
    val starships: List<String>,
    val vehicles: List<String>,
    val species: List<String>,
    val created: String,
    val edited: String,
    val url: String,

    ){

    override fun toString(): String {
        return  "${this.title} \n\n"+
                "Episode Number: \n" +
                " ${this.episodeId} \n\n" +
                " ${this.openingCrawl} \n\n" +
                "Director: \n" +
                " ${this.director} \n\n" +
                "Producers: \n" +
                " ${this.producer} \n\n" +
                "Release Date: \n" +
                " ${this.releaseDate} "
    }



}